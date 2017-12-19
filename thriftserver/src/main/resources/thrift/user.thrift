namespace java com.zjh.daily.thrift.service
struct User{
    1:string name,
    2:i32 id,
    3:i32 age
}
service UserService{
    i32 save(1:User user),
    User getById(1:i32 id)
}