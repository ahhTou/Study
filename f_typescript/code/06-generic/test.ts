class User {
    username: string | undefined
    password: string | undefined
}

class MysqlDB<T> {
    add(info: T): boolean {
        return true
    }
}


let user = new User()
user.password = '123'
user.username = 'ahhTou'

let db = new MysqlDB<User>()
db.add(user)
