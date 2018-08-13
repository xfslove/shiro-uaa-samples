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

  ##### application.yml

  里面有项配置：`shiro.uaa.server.accessTokenExpires`，默认没有启用，具体可以看配置[说明](auth/src/main/resources/application.yml)

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

  到resource目录下，执行`mvn spring-boot:run`，浏览器打开http://localhost:8080/r1

   Resource Server 2

   ##### 页面权限说明

   页面仅需要认证

   到resource-2目录下，执行`mvn spring-boot:run`，浏览器打开http://localhost:8280/r2

   可以用此Resource Server 2，结合Resource Server，看到单点登录，以及一种变相的单点登出（非实时）的效果

#### 看起来

![sample](sample.gif)

