# 用户信息 API

## 获取用户信息

GET `/v1/userInfo`

请求参数

| 参数名   | 参数定义 | 类型   | 说明     | 必填id |
| -------- | -------- | ------ | -------- | ------ |
| name     | 用户名   | string |          | n      |
| roleId   | 角色id   | int    |          | n      |
| roleName | 角色名称 | string | 模糊查询 | n      |
| pageNo   | 第几页   | int    | 默认是1  | n      |
| pageSize | 页数     | int    | 默认是10 | n      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见下表           | n    |
| message | 错误消息 | String |                  | n    |

data格式

| 参数名  | 参数定义 | 类型   | 说明             |
| ------- | -------- | ------ | ---------------- |
| id        | 用户id       | int    |                          |
| name  | 用户     | string |                          |
| roleId    | 角色id       | int |                          |
| roleName | 角色名称 | string | |
| createdAt | 创建时间     | string | "2020-05-25 17:00:03+08" |
| updatedAt | 最近更新时间 | string | "2020-05-25 17:00:03+08" |
| isDeleted | 删除标记     | int    |                          |
| count     | 总条数       | int    |                          |
| index     | 第几页       | int    |                          |
| pageSize  | 每页多少数据 | int    |                          |
| size      | 总页数       | int    |                          |




示例

#### Request

**GET** /v1/userInfo?name=ss&roleId=1&roleName=管理员&pageNo=1&pageSize=10

#### Response

```json
{
    "data": {
        "count": 2,
        "index": 1,
        "pageSize": 10,
        "size": 1,
        "returnUserInfoList": [
            {
                "id": 2,
                "name": "afu2",
                "roleId": 2,
                "roleName": "user",
                "createdAt": "2020-05-25 09:07:51+08",
                "updatedAt": "2020-05-25 09:07:53+08",
                "isDeleted": 0
            },
            {
                "id": 1,
                "name": "afu1",
                "roleId": 1,
                "roleName": "admin",
                "createdAt": "2020-05-25 09:07:07+08",
                "updatedAt": "2020-05-25 09:07:13+08",
                "isDeleted": 0
            }
        ]
    },
    "status": 0
}
```



## 获取单个用户信息

GET /v1/userInfo/{id}

请求参数

| 参数名 | 参数定义 | 类型 | 说明 | 必填id |
| ------ | -------- | ---- | ---- | ------ |
| id     | 用户ID   | int  |      | n      |



响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见下表           | n    |
| message | 错误消息 | String |                  | n    |

data格式

| 参数名    | 参数定义     | 类型   | 说明                     | 必填 |
| --------- | ------------ | ------ | ------------------------ | ---- |
| id        | 用户id       | int    |                          |      |
| name      | 用户         | string |                          |      |
| roleId    | 角色id       | int    |                          |      |
| roleName  | 角色名称     | string |                          |      |
| createdAt | 创建时间     | string | "2020-05-25 17:00:03+08" |      |
| updatedAt | 最近更新时间 | string | "2020-05-25 17:00:03+08" |      |
| isDeleted | 删除标记     | int    |                          |      |


示例

#### Request

**GET** /v1/userInfo/1

#### Response

```json
{
    "data": {
        "id": 1,
        "name": "afu1",
        "roleId": 1,
        "roleName": "admin",
        "createdAt": "2020-05-25 09:07:07+08",
        "updatedAt": "2020-05-25 09:07:13+08",
        "isDeleted": 0
    },
    "status": 0
}
```

## 新增用户

POST `/v1/userInfo`

请求参数

| 参数名   | 参数定义 | 类型   | 说明 | 必填id |
| -------- | -------- | ------ | ---- | ------ |
| name     | 用户名   | string |      | y      |
| password | 用户密码 | string |      | y      |
| roleId   | 角色id   | int    |      | y      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        |                  | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**POST** /v1/userInfo

```json
{
	"name":"dhj",
	"password":"ff",
	"roleId":1
}
```

#### Response

```json
{
    "data": 0,
    "status": 0
}
```



## 删除单个用户

DELETE /v1/userInfo/{id}

请求参数

| 参数名 | 参数定义 | 类型 | 说明 | 必填id |
| ------ | -------- | ---- | ---- | ------ |
| id     | 用户ID   | int  |      | n      |



响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**DELETE** /v1/userInfo/1

#### Response

```json
{
    "data": 0,
    "status": 0
}
```



## 修改用户信息

PUT `/v1/userInfo`

请求参数

| 参数名    | 参数定义     | 类型   | 说明 | 必填id |
| --------- | ------------ | ------ | ---- | ------ |
| id        | 用户id       | int    |      | y      |
| name      | 用户名       | string |      | y      |
| password  | 用户密码     | string |      | y      |
| roleId    | 角色id       | int    |      | y      |
| createdAt | 创建时间     | string |      | y      |
| updatedAt | 最近更新时间 | string |      | y      |
| isDeleted | 删除标记     | int    |      | y      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

PUT /v1/userInfo

```json
{
	 "id": 2,
    "name": "afu2",
    "password":"111",
    "roleId": 2,
    "createdAt": "2020-05-25 09:07:51+08",
    "updatedAt": "2020-05-25 09:07:53+08",
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



## 获取全部用户信息（不分页）

GET /v1/userInfo/nameAndId

请求参数

无

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

data格式

| 参数名       | 参数定义 | 类型   | 说明 | 必填 |
| ------------ | -------- | ------ | ---- | ---- |
| userInfoName | 用户名   | string |      |      |
| userInfoId   | 用户id   | int    |      |      |

示例

#### Request

**GET** /v1/userInfo/nameAndId

#### Response

```json
{
    "data": {
        "userInfoNameAndIdList": [
            {
                "userInfoName": "dhj",
                "userInfoId": 3
            },
            {
                "userInfoName": "afu2",
                "userInfoId": 2
            },
            {
                "userInfoName": "afu1",
                "userInfoId": 1
            }
        ]
    },
    "status": 0
}
```

## 