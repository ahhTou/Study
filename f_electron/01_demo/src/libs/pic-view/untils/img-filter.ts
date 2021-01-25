function isImageUrl(url: string): boolean {
    const types: [string] = require('./typs.json').name
    const imgReg: RegExp = new RegExp(
        '.*?(' +
            types
                .reduce((res: string, type: string): string => {
                    res += `\\.${type}|`
                    return res
                }, '')
                .slice(0, -1) +
            ')$',
        'i'
    )

    return imgReg.test(url)
}

export function filter(list: string[]): string[] {
    return list.filter((l) => isImageUrl(l))
}
