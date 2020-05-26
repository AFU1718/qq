# 项目部署记录 API

## 获取项目部署记录

GET `/v1/deployments`

请求参数

| 参数名      | 参数定义   | 类型       | 说明                                               | 必填id |
| ---------- | ---------| ---------- | -------------------------------------------------- | ---- |
| projectId | 项目id | int  |   | n   |
| projectName | 项目名称 | string | 模糊查询 | n |
| status | 部署状态 | int | 0是失败，1是成功 | n |
| pageNo | 第几页 | int | 默认是1 | n |
| pageSize | 页数 | int | 默认是10 | n |


响应

| 参数名      | 参数定义   | 类型       | 说明                                               | 必填 |
| ---------- | -------- | ---------- | -------------------------------------------------- | ---- |
| status     | 状态      | int        | 0: 成功，1: 失败                           | y    |
| data       | 响应数据   |  | 见示例 | n   |
| message    | 错误消息   | String     |                                 | n    |


示例
#### Request
**GET** /v1/deployments?projectId=1&status=1&pageNo=1&pageSize=10

#### Response
```json
{
    "data": {
        "count": 2,
        "index": 1,
        "pageSize": 10,
        "size": 1,
        "returnProjectDeploymentRecordList": [
            {
                "id": 3,
                "projectId": 2,
                "projectName": "project2",
                "status": 1,
                "version": "2.0",
                "changeLog": "changelog2",
                "developers": "a and b",
                "testers": "c",
                "deployedAt": "2018-08-09 16:59:08.853+08",
                "totalTime": 200,
                "note": "ooww",
                "creator": "afu1",
                "updater": "afu2",
                "createdAt": "2020-05-22 16:53:32.245051+08",
                "updatedAt": "2020-05-22 17:09:30.606254+08",
                "isDeleted": 1
            },
            {
                "id": 1,
                "projectId": 1,
                "projectName": "project1",
                "status": 1,
                "version": "1.0",
                "changeLog": "changelog100",
                "developers": "a and b and f",
                "testers": "c",
                "deployedAt": "2018-07-09 16:59:08.853+08",
                "totalTime": 100,
                "note": "ogfjo",
                "creator": "afu1",
                "updater": "afu2",
                "createdAt": "2020-05-22 16:23:28.383117+08",
                "updatedAt": "2020-05-22 18:10:43.391578+08",
                "isDeleted": 1
            }
        ]
    },
    "status": 0
}
```



## 获取单个项目部署记录

GET /v1/deployments/{id}

请求参数

| 参数名 | 参数定义       | 类型 | 说明 | 必填id |
| ------ | -------------- | ---- | ---- | ------ |
| id     | 项目部署记录ID | int  |      | n      |



响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**GET** /v1/deployments/1

#### Response

```json
{
    "data": {
        "id": 1,
        "projectId": 1,
        "projectName": "project1",
        "status": 1,
        "version": "1.0",
        "changeLog": "changelog100",
        "developers": "a and b and f",
        "testers": "c",
        "deployedAt": "2018-07-09 16:59:08.853+08",
        "totalTime": 100,
        "note": "ogfjo",
        "creator": "afu1",
        "updater": "afu2",
        "createdAt": "2020-05-22 16:23:28.383117+08",
        "updatedAt": "2020-05-22 18:10:43.391578+08",
        "isDeleted": 0
    },
    "status": 0
}
```


## 新增项目部署记录

POST `/v1/deployments`

请求参数

| 参数名     | 参数定义                       | 类型   | 说明                       | 必填id |
| ---------- | ------------------------------ | ------ | -------------------------- | ------ |
| projectId  | 项目id                         | int    |                            | y      |
| status     | 部署状态                       | int    | 0是失败，1是成功           | y      |
| version    | 版本信息                       | string |                            | y      |
| changeLog  | 版本更新信息                   | string |                            | y      |
| developers | 开发人员                       | string |                            | y      |
| testers    | 测试人员                       | string |                            | y      |
| deployedAt | 部署时间                       | String | “2018-08-09T08:59:08.853Z" | y      |
| totalTime  | 本次迭代开发总时间（单位：天） | int    |                            | y      |
| note       | 备注                           | int    |                            | y      |
| createdBy  | 创建人id                       | int    |                            | y      |
| updatedBy  | 最新更新人id                   | int    |                            | y      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**POST** /v1/deployments

```json
{
  "projectId": 3,
  "status": 1,
  "version": "2.0",
  "changeLog": "changelog2",
  "developers": "a and b",
  "testers": "c",
  "deployedAt":  "2018-08-09T08:59:08.853Z",
  "totalTime": 200,
  "note": "ooww",
  "createdBy": 1,
  "updatedBy": 1
}
```

#### Response

```json
{
    "data": 0,
    "status": 0
}
```



## 删除单个项目部署记录

DELETE /v1/deployments/{id}

请求参数

| 参数名 | 参数定义       | 类型 | 说明 | 必填id |
| ------ | -------------- | ---- | ---- | ------ |
| id     | 项目部署记录ID | int  |      | n      |



响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**DELETE** /v1/deployments/1

#### Response

```json
{
    "data": 0,
    "status": 0
}
```



## 修改项目部署记录

PUT `/v1/deployments`

请求参数

| 参数名     | 参数定义                       | 类型   | 说明                       | 必填id |
| ---------- | ------------------------------ | ------ | -------------------------- | ------ |
| id         | 项目部署记录id                 | int    |                            | y      |
| projectId  | 项目id                         | int    |                            | y      |
| status     | 部署状态                       | int    | 0是失败，1是成功           | y      |
| version    | 版本信息                       | string |                            | y      |
| changeLog  | 版本更新信息                   | string |                            | y      |
| developers | 开发人员                       | string |                            | y      |
| testers    | 测试人员                       | string |                            | y      |
| deployedAt | 部署时间                       | String | “2018-08-09T08:59:08.853Z" | y      |
| totalTime  | 本次迭代开发总时间（单位：天） | int    |                            | y      |
| note       | 备注                           | string |                            | y      |
| createdBy  | 创建人id                       | int    |                            | y      |
| updatedBy  | 最新更新人id                   | int    |                            | y      |
| createdAt  | 创建时间                       | string |                            | y      |
| updatedAt  | 最近更新时间                   | string |                            | y      |
| isDeleted  | 删除标记                       | int    |                            | y      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

PUT /v1/deployments

```json
{
    "id": 1,
    "projectId": 1,
    "status": 1,
    "version": "1.0",
    "changeLog": "changelog1",
    "developers": "a and b",
    "testers": "c",
    "deployedAt": "2018-07-09 16:59:08.853+08",
    "totalTime": 100,
    "note": "oo",
    "createdBy": 1,
    "updatedBy": 1,
    "createdAt": "2020-05-22 16:23:28.383117+08",
    "updatedAt": "2020-05-22 16:23:28.383117+08",
    "isDeleted": 0
}
```

#### Response

```json
{
    "data": 0,
    "status": 0
}
```

