# 角色 API

## 获取角色

GET `/v1/roles`

请求参数

| 参数名   | 参数定义 | 类型   | 说明     | 必填id |
| -------- | -------- | ------ | -------- | ------ |
| roleName | 角色名称 | string |          | n      |
| pageNo   | 第几页   | int    | 默认是1  | n      |
| pageSize | 页数     | int    | 默认是10 | n      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**GET** /v1/roles?roleName=admin&pageNo=1&pageSize=10

#### Response

```json
{
    "data": {
        "count": 2,
        "index": 1,
        "pageSize": 10,
        "size": 1,
        "roleList": [
            {
                "id": 2,
                "roleName": "user",
                "note": "普通成员",
                "createdAt": "2020-05-25 17:00:03+08",
                "updatedAt": "2020-05-25 17:00:06+08",
                "isDeleted": 0
            },
            {
                "id": 1,
                "roleName": "admin",
                "note": "管理员",
                "createdAt": "2020-05-25 16:59:32+08",
                "updatedAt": "2020-05-25 16:59:35+08",
                "isDeleted": 0
            }
        ]
    },
    "status": 0
}
```



## 获取单个角色

GET /v1/roles/{id}

请求参数

| 参数名 | 参数定义 | 类型 | 说明 | 必填id |
| ------ | -------- | ---- | ---- | ------ |
| id     | 角色ID   | int  |      | n      |



响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**GET** /v1/roles/1

#### Response

```json
{
    "data": {
        "id": 1,
        "roleName": "admin",
        "note": "管理员",
        "createdAt": "2020-05-25 16:59:32+08",
        "updatedAt": "2020-05-25 16:59:35+08",
        "isDeleted": 0
    },
    "status": 0
}
```

## 新增角色

POST `/v1/roles`

请求参数

| 参数名   | 参数定义 | 类型   | 说明 | 必填id |
| -------- | -------- | ------ | ---- | ------ |
| roleName | 角色名称 | string |      | y      |
| note     | 备注     | string |      | y      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**POST** /v1/roles

```json
{
	"roleName":"普通角色",
	"note":"自定义"
}
```

#### Response

```json
{
    "data": 0,
    "status": 0
}
```



## 删除单个角色

DELETE /v1/roles/{id}

请求参数

| 参数名 | 参数定义 | 类型 | 说明 | 必填id |
| ------ | -------- | ---- | ---- | ------ |
| id     | 角色ID   | int  |      | n      |



响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**DELETE** /v1/roles/1

#### Response

```json
{
    "data": 0,
    "status": 0
}
```



## 修改角色

PUT `/v1/projectGroups`

请求参数

| 参数名    | 参数定义     | 类型   | 说明 | 必填id |
| --------- | ------------ | ------ | ---- | ------ |
| id        | 角色id       | int    |      | y      |
| roleName  | 角色名称     | string |      | y      |
| note      | 备注         | string |      | y      |
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

PUT /v1/roles

```json
{
	"id": 2,
    "roleName": "user",
    "note": "普通成员",
    "createdAt": "2020-05-25 17:00:03+08",
    "updatedAt": "2020-05-25 17:00:06+08",
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



## 获取全部角色（不分页）

GET /v1/roles/nameAndId

请求参数

无

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**GET** /v1/roles/nameAndId

#### Response

```json
{
    "data": {
        "roleNameAndIdList": [
            {
                "roleName": "dhj",
                "roleId": 3
            },
            {
                "roleName": "user",
                "roleId": 2
            },
            {
                "roleName": "admin",
                "roleId": 1
            }
        ]
    },
    "status": 0
}
```

## 