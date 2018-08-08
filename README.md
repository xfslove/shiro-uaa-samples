# shiro-uaa samples

#### 说明

- auth

  UAA Server

  ##### 测试账号说明

  | 用户名 | 密码   | 角色权限     |
  | ------ | ------ | ------------ |
  | test1  | 123    | perm1, perm2 |
  | test2  | 123456 | perm3, perm4 |

  ##### 运行

  到auth目录下，执行`mvn spring-boot:run`

- resource

  Resource Server

  ##### 页面权限说明

  | 页面URI | 需要权限 |
  | ------- | -------- |
  | /view1  | perm1    |
  | /view2  | perm2    |
  | /view3  | perm3    |
  | /view4  | perm4    |

  ##### 运行

  到resource目录下，执行`mvn spring-boot:run`，浏览器打开http://localhost:8080

#### 看起来

![sample](sample.gif)

