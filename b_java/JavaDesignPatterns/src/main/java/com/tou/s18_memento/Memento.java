package com.tou.s18_memento;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 备忘录对象，负责，保存好纪录
 * 即 Originator 的内部状态
 */
@Data
@AllArgsConstructor
public class Memento {

    private String state;

}
