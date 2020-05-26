package com.zz.ady.common.mail

import java.net.URL
import java.text.SimpleDateFormat
import java.util.regex.Pattern
import java.util.{Date, Properties}

import com.typesafe.config.{Config, ConfigFactory}
import com.typesafe.scalalogging.Logger
import javax.activation.{DataHandler, FileDataSource}
import javax.mail.internet.{InternetAddress, MimeBodyPart, MimeMessage, MimeMultipart, MimeUtility}
import javax.mail.{Address, Message, Session}

import scala.util.{Failure, Success, Try}

object JavaMailHelper {

  def apply(): JavaMailHelper = new JavaMailHelper {}

}

trait JavaMailHelper {

  val logger = Logger(this.getClass)

  val conf: Config = ConfigFactory.load()

  val myEmailAccount: String = conf.getString("mail.email")
  val myEmailPassword: String =  conf.getString("mail.password") //设置登陆密码
  val myEmailSMTPHost: String = conf.getString("mail.host")
  val smtpPort: String = conf.getString("mail.port")

  val  personal: String = conf.getString("mail.personal")

  val reportFilePath: String = conf.getString("upload.file.report-file-save-path")

  def sendMessage(subject: String, content: String, receiveMailAccount: String, url: Option[URL], fileName: String = ""): Option[Boolean] = {
    Try {
      val props = new Properties
      props.setProperty("mail.transport.protocol", "smtp")
      props.setProperty("mail.smtp.host", myEmailSMTPHost)
      props.setProperty("mail.smtp.auth", "true")
      props.setProperty("X-Mailer", "Microsoft Outlook Express 6.00.2900.2869")
      props.setProperty("mail.smtp.port", smtpPort)
      props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory")
      props.setProperty("mail.smtp.socketFactory.fallback", "false")
      props.setProperty("mail.smtp.socketFactory.port", smtpPort)
      props.setProperty("mail.smtp.connectiontimeout", "5000")
      props.setProperty("mail.smtp.timeout", "5000")

      val session = Session.getInstance(props)
      session.setDebug(true)
      logger.info("create mail subject = {}, receiveMailAccount = {}, content = {}", subject, receiveMailAccount, content)

      val message = if (url.nonEmpty) createReportMimeMessage(session, myEmailAccount, receiveMailAccount, subject, receiveMailAccount, content, url.getOrElse(new URL("")), fileName)
      else createMimeMessage(session, myEmailAccount, receiveMailAccount, subject, receiveMailAccount, content)

      val transport = session.getTransport
      logger.info("connect")
      transport.connect(myEmailSMTPHost, myEmailAccount, myEmailPassword)
      transport.sendMessage(message, message.getAllRecipients)
      logger.info("send")
      transport.close()
    } match {
      case Success(_) => Some(true)
      case Failure(e) =>
        e.printStackTrace()
        logger.error("Failed to send email, error: {}", e)
        None
    }
  }

  def createMimeMessage(session: Session, sendMail: String, receiveMail: String, subject: String, recipient: String, content: String): MimeMessage = {
    val message = new MimeMessage(session)
    message.setFrom(new InternetAddress(sendMail, personal, "UTF-8"))
    val recipientAddress: Array[Address] = recipient.split(";").map(x => new InternetAddress(x, x, "UTF-8"))
    message.setRecipients(Message.RecipientType.TO, recipientAddress)
//    message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveMail, recipient, "UTF-8"))
    message.setSubject(subject, "UTF-8")
    message.setContent(content, "text/html;charset=UTF-8")
    message.setSentDate(new Date)
    message.saveChanges()
    message
  }

  def createReportMimeMessage(session: Session, sendMail: String, receiveMail: String, subject: String
                              , recipient: String, content: String, url: URL/*data:Array[Byte], */, fileName: String): MimeMessage = {
    val message = new MimeMessage(session)
    message.setFrom(new InternetAddress(sendMail, personal, "UTF-8"))
//    message.setRecipients(Message.RecipientType.TO, recipient)
    val recipientAddress: Array[Address] = recipient.split(";").map(x => new InternetAddress(x, x, "UTF-8"))
//    message.setRecipient(Message.RecipientType.TO, new InternetAddress(receiveMail, recipient, "UTF-8"))
    message.setRecipients(Message.RecipientType.TO, recipientAddress)
    message.setSubject(subject, "UTF-8")
    val multipart = new MimeMultipart
    val messageBodyPart = new MimeBodyPart()
    messageBodyPart.setContent(content, "text/html;charset=UTF-8")
    logger.info("createReportMimeMessage_fileName1 = {}", fileName)
//    val source: FileDataSource = new FileDataSource(
//      FileUtil.byteToFile(
//        data,reportFilePath.concat(new SimpleDateFormat("yyyyMMdd").format(new Date())+fileName)
//      )
//    )
    val fileBodyPart = new MimeBodyPart()
//    fileBodyPart.setDataHandler(new DataHandler(source))
    fileBodyPart.setDataHandler(new DataHandler(url))
    fileBodyPart.setFileName(MimeUtility.encodeText(fileName))
//    messageBodyPart.setDataHandler(new DataHandler(source))
//    messageBodyPart.setFileName(MimeUtility.encodeText(fileName))
    logger.info("createReportMimeMessage_fileName2 = {}", fileName)
    multipart.addBodyPart(messageBodyPart)
    multipart.addBodyPart(fileBodyPart)
    message.setContent(multipart)
    message.setSentDate(new Date)
    message.saveChanges()
    message
  }

  def checkPattern(email: String) = {
    Pattern.compile("^([A-Za-z0-9_\\-\\.\\u4e00-\\u9fa5])+\\@([A-Za-z0-9_\\-\\.])+\\.([A-Za-z]{2,8})$").
      matcher(email).matches()
  }
}