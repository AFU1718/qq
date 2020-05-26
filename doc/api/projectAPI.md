# 项目 API

## 获取项目

GET `/v1/projects`

请求参数

| 参数名           | 参数定义   | 类型   | 说明     | 必填id |
| ---------------- | ---------- | ------ | -------- | ------ |
| projectGroupId   | 项目组id   | int    |          | n      |
| projectGroupName | 项目组名称 | string | 模糊查询 | n      |
| projectName      | 项目名称   | string | 模糊查询 | n      |
| projectType      | 项目类型   | string |          | n      |
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
| id  | 项目id  | int    |  |     |
| projectGroupId | 项目组id | int | | |
| projectGroupName | 项目组名称 | string |            |     |
| projectName | 项目名称 | string | | |
| projectType | 项目类型 | string | | |
| note | 备注 | string |                  |     |
| creator | 创建人名称 | string | |  |
| updater | 最近更新人名称 | string | |  |
| createdAt | 创建时间     | string | "2020-05-25 17:00:03+08" ||
| updatedAt | 最近更新时间 | string | "2020-05-25 17:00:03+08" ||
| isDeleted | 删除标记     | int    |                          ||
| count     | 总条数       | int    |                          ||
| index     | 第几页       | int    |                          ||
| pageSize  | 每页多少数据 | int    |                          ||
| size      | 总页数       | int    |                          ||

示例

#### Request

**GET** /v1/projects?projectGroupId=1&projectGroupName=project&projectName=project&projectType=scala&pageNo=1&pageSize=10

#### Response

```json
{
    "data": {
        "count": 4,
        "index": 1,
        "pageSize": 10,
        "size": 1,
        "returnProjectList": [
            {
                "id": 4,
                "projectGroupId": 3,
                "projectGroupName": "hhh project",
                "projectName": "project hjhjd",
                "projectType": "java",
                "note": "ooww",
                "creator": "afu1",
                "updater": "afu1",
                "createdAt": "2020-05-25 14:58:52.016311+08",
                "updatedAt": "2020-05-25 14:58:52.016311+08",
                "isDeleted": 0
            },
            {
                "id": 3,
                "projectGroupId": 1,
                "projectGroupName": "projectGroup1",
                "projectName": "project hq",
                "projectType": "java",
                "note": "ooww",
                "creator": "afu1",
                "updater": "afu1",
                "createdAt": "2020-05-25 14:58:34.765448+08",
                "updatedAt": "2020-05-25 14:58:34.765448+08",
                "isDeleted": 0
            },
            {
                "id": 2,
                "projectGroupId": 2,
                "projectGroupName": "projectGroup2",
                "projectName": "project2",
                "projectType": "scala",
                "note": "jj",
                "creator": "afu1",
                "updater": "afu2",
                "createdAt": "2020-05-25 11:27:53+08",
                "updatedAt": "2020-05-25 15:03:23.338061+08",
                "isDeleted": 0
            },
            {
                "id": 1,
                "projectGroupId": 1,
                "projectGroupName": "projectGroup1",
                "projectName": "project1",
                "projectType": "scala",
                "note": "jj",
                "creator": "afu1",
                "updater": "afu2",
                "createdAt": "2020-05-25 11:27:26+08",
                "updatedAt": "2020-05-25 15:02:26.011801+08",
                "isDeleted": 0
            }
        ]
    },
    "status": 0
}
```



## 获取单个项目

GET /v1/projects/{id}

请求参数

| 参数名 | 参数定义 | 类型 | 说明 | 必填id |
| ------ | -------- | ---- | ---- | ------ |
| id     | 项目ID   | int  |      | n      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见下表           | n    |
| message | 错误消息 | String |                  | n    |

data格式

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| id  | 项目id  | int    |  |     |
| projectGroupId | 项目组id | int | | |
| projectGroupName | 项目组名称 | string |            |     |
| projectName | 项目名称 | string | | |
| projectType | 项目类型 | string | | |
| note | 备注 | string |                  |     |
| creator | 创建人名称 | string | |  |
| updater | 最近更新人名称 | string | |  |
| createdAt | 创建时间     | string | "2020-05-25 17:00:03+08" ||
| updatedAt | 最近更新时间 | string | "2020-05-25 17:00:03+08" ||
| isDeleted | 删除标记     | int    |                          ||

示例

#### Request

**GET** /v1/projects/1

#### Response

```json
{
    "data": {
        "id": 1,
        "projectGroupId": 1,
        "projectGroupName": "projectGroup1",
        "projectName": "project1",
        "projectType": "scala",
        "note": "jj",
        "creator": "afu1",
        "updater": "afu2",
        "createdAt": "2020-05-25 11:27:26+08",
        "updatedAt": "2020-05-25 11:27:30+08",
        "isDeleted": 0
    },
    "status": 0
}
```

## 新增项目

POST `/v1/projects`

请求参数

| 参数名         | 参数定义     | 类型   | 说明 | 必填id |
| -------------- | ------------ | ------ | ---- | ------ |
| projectGroupId | 项目组id     | int    |      | y      |
| projectName    | 项目名称     | string |      | y      |
| projectType    | 项目类型     | string |      | y      |
| note           | 备注         | string |      | y      |
| createdBy      | 创建人id     | int    |      | y      |
| updatedBy      | 最新更新人id | int    |      | y      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**POST** /v1/projects

```json
{
      "projectGroupId": 1,
      "projectName": "project hjhjd",
      "projectType": "java",
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



## 删除单个项目

DELETE /v1/projects/{id}

请求参数

| 参数名 | 参数定义 | 类型 | 说明 | 必填id |
| ------ | -------- | ---- | ---- | ------ |
| id     | 项目ID   | int  |      | n      |



响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

示例

#### Request

**DELETE** /v1/projects/1

#### Response

```json
{
    "data": 0,
    "status": 0
}
```



## 修改项目

PUT `/v1/projects`

请求参数

| 参数名         | 参数定义     | 类型   | 说明 | 必填id |
| -------------- | ------------ | ------ | ---- | ------ |
| id             | 项目id       | int    |      | y      |
| projectGroupId | 项目组id     | string |      | y      |
| projectName    | 项目名称     | string |      | y      |
| projectType    | 项目类型     | string |      | y      |
| note           | 备注         | string |      | y      |
| createdBy      | 创建人id     | int    |      | y      |
| updatedBy      | 最新更新人id | int    |      | y      |
| createdAt      | 创建时间     | string |      | y      |
| updatedAt      | 最近更新时间 | string |      | y      |
| isDeleted      | 删除标记     | int    |      | y      |

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        |                  | n    |
| message | 错误消息 | String |                  | n    |


示例

#### Request

PUT /v1/projects

```json
{
     "id": 1,
     "projectGroupId": 1,
     "projectName":"project ufudsh",
     "projectType":"PYTHON",
     "note": "qq",
     "created_by": 1,
     "updated_by": 2,
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



## 获取全部项目（不分页）

GET /v1/projects/nameAndId

请求参数

无

响应

| 参数名  | 参数定义 | 类型   | 说明             | 必填 |
| ------- | -------- | ------ | ---------------- | ---- |
| status  | 状态     | int    | 0: 成功，1: 失败 | y    |
| data    | 响应数据 |        | 见示例           | n    |
| message | 错误消息 | String |                  | n    |

data格式

| 参数名      | 参数定义 | 类型   | 说明 | 必填 |
| ----------- | -------- | ------ | ---- | ---- |
| projectName | 项目名称 | string |      |      |
| projectId   | 项目id   | int    |      |      |

示例

#### Request

**GET** /v1/projects/nameAndId

#### Response

```json
{
    "data": {
        "projectNameAndIdList": [
            {
                "projectName": "project hjhjd",
                "projectId": 4
            },
            {
                "projectName": "project hq",
                "projectId": 3
            },
            {
                "projectName": "project2",
                "projectId": 2
            },
            {
                "projectName": "project1",
                "projectId": 1
            }
        ]
    },
    "status": 0
}
```

## 