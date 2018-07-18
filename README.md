# mlearn
Admin template.


0. Config : 

 - ApplicationContext

    ![applicationContext](imgs/config/applicationContext.png)

 - Spring mvc
    
    ![spring mvc](imgs/config/spring-mvc.png)
    
1. class define

 - Package Name: Args[class]

 - Vo: ResultUtil
 
 - Config: AuthenticationInterceptor
 
 - Controller: AdminController, BookController, UserController, LoginController
 
 - Service(Implement): AdminService, BookService, OrderService, UserService
 
 - Entity: Admin, Book, Order, OrderItem, User
 
 - Mapper: AdminMapper, BookMapper, OrderItemMapper, OrderMapper, UserMapper
 
 - Util: CacheUtil, EncryptUtil, FileUtil, HexUtil, JsonUtil, QiNiuUtil
 
2. Detail design

 - login:
    
    No encryption frontend, Ajax send username & password directly.

    Backstage: Sha256(salt + password_from_front).equals(exist_password) -> update salt and password

 - BookCSM & UserCSM & OrderCSM

    - 



