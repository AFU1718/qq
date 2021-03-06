# 项目组 API

## 获取项目组记录

GET `/v1/projectGroups`

请求参数

| 参数名           | 参数定义   | 类型   | 说明     | 必填id |
| ---------------- | ---------- | ------ | -------- | ------ |
| projectGroupName | 项目组名称 | string | 模糊查询 | n      |
| pageNo           | 第几页     | int    | 默认是1  | n      |
| pageSize         | 页数       | int    | 默认是10 | n      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见下表           | n    |
| message | 错误消息 | String |                  | n    |

data格式

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| id  | 项目组id | int    |  |     |
| projectGroupName | 项目组名称 | string |            |     |
| note      | 备注         | string |                          ||
| creator | 创建人名称 | string | ||
| updater | 最近更新人名称 | string | ||
| createdAt | 创建时间     | string | "2020-05-25 17:00:03+08" ||
| updatedAt | 最近更新时间 | string | "2020-05-25 17:00:03+08" ||
| isDeleted | 删除标记     | int    |                          ||
| count     | 总条数       | int    |                          ||
| index     | 第几页       | int    |                          ||
| pageSize  | 每页多少数据 | int    |                          ||
| size      | 总页数       | int    |                          ||

示例

#### Request

**GET** /v1/projectGroups?projectGroupName=project&pageNo=1&pageSize=10

#### Response

```json
{
    "data": {
        "count": 4,
        "index": 1,
        "pageSize": 10,
        "size": 1,
        "returnProjectGroupList": [
            {
                "id": 4,
                "projectGroupName": "kkk project",
                "note": "djmk",
                "creator": "afu2",
                "updater": "afu2",
                "createdAt": "2020-05-25 14:05:39.575578+08",
                "updatedAt": "2020-05-25 14:05:39.575578+08",
                "isDeleted": 0
            },
            {
                "id": 3,
                "projectGroupName": "hhh project",
                "note": "dj",
                "creator": "afu1",
                "updater": "afu2",
                "createdAt": "2020-05-25 14:02:13.422565+08",
                "updatedAt": "2020-05-25 14:02:13.422565+08",
                "isDeleted": 0
            },
            {
                "id": 2,
                "projectGroupName": "projectGroup2",
                "note": "ww",
                "creator": "afu1",
                "updater": "afu2",
                "createdAt": "2020-05-25 13:42:27+08",
                "updatedAt": "2020-05-25 13:42:30+08",
                "isDeleted": 0
            },
            {
                "id": 1,
                "projectGroupName": "projectGroup1",
                "note": "qq",
                "creator": "afu1",
                "updater": "afu2",
                "createdAt": "2020-05-25 13:42:06+08",
                "updatedAt": "2020-05-25 13:42:09+08",
                "isDeleted": 0
            }
        ]
    },
    "status": 0
}
```



## 获取单个项目组

GET /v1/projectGroups/{id}

请求参数

| 参数名 | 参数定义 | 类型 | 说明 | 必填id |
| ------ | -------- | ---- | ---- | ------ |
| id     | 项目组ID | int  |      | n      |



响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

data格式

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| id  | 项目组id | int    |  |     |
| projectGroupName | 项目组名称 | string |            |     |
| note      | 备注         | string |                          ||
| creator | 创建人名称 | string | ||
| updater | 最近更新人名称 | string | ||
| createdAt | 创建时间     | string | "2020-05-25 17:00:03+08" ||
| updatedAt | 最近更新时间 | string | "2020-05-25 17:00:03+08" ||
| isDeleted | 删除标记     | int    |                          ||

示例

#### Request

**GET** /v1/projectGroups/1

#### Response

```json
{
    "data": {
        "id": 1,
        "projectGroupName": "projectGroup1",
        "note": "qq",
        "creator": "1",
        "updater": "2",
        "createdAt": "2020-05-25 13:42:06+08",
        "updatedAt": "2020-05-25 13:42:09+08",
        "isDeleted": 0
    },
    "status": 0
}
```

## 新增项目组

POST `/v1/projectGroups`

请求参数

| 参数名           | 参数定义     | 类型   | 说明 | 必填id |
| ---------------- | ------------ | ------ | ---- | ------ |
| projectGroupName | 项目组名称   | string |      | y      |
| note             | 备注         | string |      | y      |
| createdBy        | 创建人id     | int    |      | y      |
| updatedBy        | 最新更新人id | int    |      | y      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**POST** /v1/projectGroups

```json
{
	"projectGroupName":"kkk project",
	"note":"djmk",
	"createdBy":2,
	"updatedBy":2
}
```

#### Response

```json
{
    "data": 0,
    "status": 0
}
```



## 删除单个项目组

DELETE /v1/projectGroups/{id}

请求参数

| 参数名 | 参数定义 | 类型 | 说明 | 必填id |
| ------ | -------- | ---- | ---- | ------ |
| id     | 项目组ID | int  |      | n      |



响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**DELETE** /v1/projectGroups/1

#### Response

```json
{
    "data": 0,
    "status": 0
}
```



## 修改项目组

PUT `/v1/projectGroups`

请求参数

| 参数名           | 参数定义     | 类型   | 说明 | 必填id |
| ---------------- | ------------ | ------ | ---- | ------ |
| id               | 项目组id     | int    |      | y      |
| projectGroupName | 项目组名称   | string |      | y      |
| note             | 备注         | string |      | y      |
| createdBy        | 创建人id     | int    |      | y      |
| updatedBy        | 最新更新人id | int    |      | y      |
| createdAt        | 创建时间     | string |      | y      |
| updatedAt        | 最近更新时间 | string |      | y      |
| isDeleted        | 删除标记     | int    |      | y      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        |                  | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

PUT /v1/projectGroups

```json
{
     "id": 1,
     "projectGroupName": "projectGroup1",
     "note": "qq",
     "creator": "afu1",
     "updater": "afu2",
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



## 获取全部项目组（不分页）

GET /v1/projectGroups/nameAndId

请求参数

无

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

data格式

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| projectGroupName | 项目组名称 | string |            |  |
| projectGroupId | 项目组id  | int |                          ||
示例

#### Request

**GET** /v1/projectGroups/nameAndId

#### Response

```json
{
    "data": {
        "projectGroupNameAndIdList": [
            {
                "projectGroupName": "kkk project",
                "projectGroupId": 4
            },
            {
                "projectGroupName": "hhh project",
                "projectGroupId": 3
            },
            {
                "projectGroupName": "projectGroup2",
                "projectGroupId": 2
            },
            {
                "projectGroupName": "projectGroup1",
                "projectGroupId": 1
            }
        ]
    },
    "status": 0
}
```

## 