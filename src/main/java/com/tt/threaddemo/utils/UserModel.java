package com.tt.threaddemo.utils;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hansiyuan
 * @date 2021年06月16日 20:10
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class UserModel {
    private Integer age;
    private String name;
}
