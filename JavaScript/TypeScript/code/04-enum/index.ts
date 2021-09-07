enum Gender {
    Female,
    male,
}

let woman: Gender

let man: Gender

woman = Gender.Female

man = Gender.male

// 默认情况是, 默认指定 0，1，2... ,可以手动指定
enum GenderDefault {
    Female = 0,
    male = 1,
}

// 可以修改为字符串枚举，需要手动指定
enum GenderString {
    Female = 'FEMALE',
    male = 'MALE',
}
