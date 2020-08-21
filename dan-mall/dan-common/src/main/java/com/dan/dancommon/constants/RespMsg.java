package com.dan.dancommon.constants;

/**
 * @Author lijun
 * @Description 返回应答常量
 * @Date 2020-06-11 1:27 下午
 **/

public class RespMsg {

    /** 0000 成功 */
    public static final String SUCCESS_MSG                                                      = "成功";

    /** 9999 请求失败 */
    public static final String ERROR_MSG                                                        = "服务器异常,请稍候";

    /** 1111 请求参数 */
    public static final String VALIDATE_PARAMS_ERROR_MSG                                        = "请求参数校验失败";

    /** 2222 请求时间 */
    public static final String VALIDATE_TIME_ERROR_MSG                                          = "时间戳校验失败";

    /** 3333 请求签名 */
    public static final String VALIDATE_SING_ERROR_MSG                                          = "签名校验失败";

    /** 3333 请求token */
    public static final String VALIDATE_TOKEN_ERROR_MSG                                         = "TOKEN校验失败";

    /** 0001-0999 业务处理 */
    public static final String INSERT_AUTH_ERROR_MSG                                            = "权限新增异常，请稍后再试";

    public static final String UPDATE_AUTH_ERROR_MSG                                            = "更新权限失败，请稍后重试";

    public static final String UPDATE_AUTH_STATUS_ERROR_MSG                                     = "更新权限状态失败，请稍后重试";

    public static final String INSERT_ROLE_REPEAT_ERROR_MSG                                     = "角色名称已存在，请更换名称重试";

    public static final String INSERT_ROLE_ERROR_MSG                                            = "新增角色失败，请稍后重试";

    public static final String UPDATA_ROLE_REPEAT_ERROR_MSG                                     = "角色名称已存在，请更换名称重试";

    public static final String UPDATE_ROLE_ERROR_MSG                                            = "更新角色失败，请稍后再试";

    public static final String INSERT_ROLE_AUTH_ERROR_MSG                                       = "角色绑定权限失败，请稍后重试";

    public static final String UPDATE_ROLE_STATUS_ERROR_MSG                                     = "角色状态更新失败，请稍后重试";

    public static final String LOGIN_WITHOUT_USERNAME_ERROR_MSG                                 = "账号不能为空";

    public static final String LOGIN_WITHOUT_PASSWORD_ERROR_MSG                                 = "密码不能为空";

    public static final String LOGIN_WITHOUT_CODE_ERROR_MSG                                     = "验证信息不能为空";

    public static final String LOGIN_CODE_OVER_ERROR_MSG                                        = "验证码过期，请重新获取";

    public static final String LOGIN_CODE_WRONG_ERROR_MSG                                       = "验证码错误，请重新输入";

    public static final String LOGIN_CODE_WRONG_OUT_ERROR_MSG                                   = "验证码在30分钟内错误超过3次，请3小时后重试";

    public static final String LOGIN_USERNAME_WRONG_ERROR_MSG                                   = "用户名不存在，请检查用户名";

    public static final String LOGIN_USERNAME_STATUS_ERROR_MSG                                  = "用户状态锁定，请联系管理员";

    public static final String UPDATE_STATUS_CHECK_ROLE_ERROR_MSG                               = "角色已绑定用户，请解绑后重试";

    public static final String UPDATE_STATUS_CHECK_AUTH_ERROR_MSG                               = "权限已绑定角色，请解绑后重试";

    public static final String OLD_PASSWORD_ERROR_MSG                                           = "旧密码不正确，请重新输入";

    public static final String NEW_PASSWORD_NOT_ERROR_MSG                                       = "新密码不能为空，请重新输入";

    public static final String NEW_PASSWORD_ERROR_MSG                                           = "两次密码输入不一致，请重新输入";

    public static final String UPDATE_PASSWORD_ERROR_MSG                                        = "修改密码失败，稍后重试";

    public static final String ADD_PRODUCT_CATEGORY_ERROR_MSG                                   = "新增商品分类失败，请稍后重试";

    public static final String ADD_PRODUCT_CATEGORY_REPEAT_ERROR_MSG                            = "商品分类名称已经存在，请修改后重试";

    public static final String LOGIN_WITHOUT_PHONE_ERROR_MSG                                    = "手机号不能为空";

    public static final String LOGIN_PHONE_WRONG_ERROR_MSG                                      = "手机号不存在，请检查手机号";

    public static final String LOGIN_CODE_WRONG_ONE_ERROR_MSG                                   = "验证码不正确,再错误两次账号将锁定";

    public static final String LOGIN_CODE_WRONG_TWO_ERROR_MSG                                   = "验证码不正确,再错误一次账号将锁定";

    public static final String REGISTER_USER_ACCOUNT_REPEAT_ERROR_MSG                           = "账号已经存在，请修改账号";

    public static final String REGISTER_USER_PHONE_REPEAT_ERROR_MSG                             = "手机号已经存在，请修改手机号";

    public static final String REGISTER_USE_ERROR_MSG                                           = "注册账号异常，请稍后重试";

    public static final String LOGIN_WITHOUT_ACCOUNT_ERROR_MSG                                  = "账号不能为空";

    public static final String LOGIN_PASSWORD_WRONG_ONE_ERROR_MSG                               = "密码不正确,再错误两次账号将锁定";

    public static final String LOGIN_PASSWORD_WRONG_TWO_ERROR_MSG                               = "密码不正确,再错误一次账号将锁定";

    public static final String LOGIN_PASSWORD_WRONG_OUT_ERROR_MSG                               = "密码在30分钟内错误超过3次，请3小时后重试";

    public static final String INSERT_PRODUCT_ATTRIBUTE_CATEGORY_REPEAT_ERROR_MSG               = "商品类型名称已经存在，请修改后重试";

    public static final String UPDATE_PRODUCT_CATEGORY_REPEAT_ERROR_MSG                         = "商品分类名称已经存在，请修改后重试";

    public static final String UPDATE_PRODUCT_CATEGORY_ERROR_MSG                                = "修改商品分类失败，请稍后重试";

    public static final String INSERT_PRODUCT_ATTRIBUTE_CATEGORY_ERROR_MSG                      = "新增商品类型失败，请稍后重试";

    public static final String UPDATE_PRODUCT_ATTRIBUTE_CATEGORY_REPEAT_ERROR_MSG               = "商品类型名称已经存在，请修改后重试";

    public static final String UPDATE_PRODUCT_ATTRIBUTE_CATEGORY_ERROR_MSG                      = "新增商品类型失败，请稍后重试";

    public static final String DELETE_PRODUCT_ATTRIBUTE_CATEGORY_ERROR_MSG                      = "删除商品类型失败，请稍后重试";

    public static final String INSERT_PRODUCT_ATTRIBUTE_REPEAT_ERROR_MSG                        = "商品属性名称已经存在，请修改后重试";

    public static final String INSERT_PRODUCT_ATTRIBUTE_ERROR_MSG                               = "新增商品属性失败，请稍后重试";

    public static final String UPDATE_PRODUCT_ATTRIBUTE_REPEAT_ERROR_MSG                        = "商品属性名称已经存在，请修改后重试";

    public static final String UPDATE_PRODUCT_ATTRIBUTE_ERROR_MSG                               = "修改商品属性失败，请稍后重试";

    public static final String DELETE_PRODUCT_ATTRIBUTE_ERROR_MSG                               = "删除商品属性失败，请稍后重试";
    
    public static final String INSERT_PRODUCT_ERROR_MSG                                         = "新增商品失败，请稍后重试";

    public static final String UPDATE_PRODUCT_ERROR_MSG                                         = "修改商品失败，请稍后重试";

    public static final String DELETE_PRODUCT_ERROR_MSG                                         = "删除商品失败，请稍后重试";

    public static final String INSERT_MEMBER_LEVEL_REPEAT_ERROR_MSG                             = "会员等级名称已存在，请修改后重试";

    public static final String INSERT_MEMBER_LEVEL_ERROR_MSG                                    = "新增会员等级失败，请稍后重试";

    public static final String UPDATE_MEMBER_LEVEL_REPEAT_ERROR_MSG                             = "会员等级名称已存在，请修改后重试";

    public static final String UPDATE_MEMBER_LEVEL_ERROR_MSG                                    = "修改会员等级失败，请稍后重试";

    public static final String DELETE_MEMBER_LEVEL_ERROR_MSG                                    = "删除会员等级失败，请稍后重试";

}
