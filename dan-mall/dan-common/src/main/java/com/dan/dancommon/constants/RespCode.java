package com.dan.dancommon.constants;

/**
 * @Author lijun
 * @Description 返回应答码
 * @Date 2020-06-11 1:26 下午
 **/

public class RespCode {
    /** 0000 成功 */
    public static final String SUCCESS                                                      = "0000";

    /** 9999 失败 */
    public static final String ERROR                                                        = "9999";

    /** 1111 请求参数 */
    public static final String VALIDATE_PARAMS_ERROR                                        = "1111";

    /** 2222 请求时间 */
    public static final String VALIDATE_TIME_ERROR                                          = "2222";

    /** 3333 请求签名 */
    public static final String VALIDATE_SING_ERROR                                          = "3333";

    /** 3333 请求token */
    public static final String VALIDATE_TOKEN_ERROR                                         = "4444";

    /** 0001-0999 业务处理 */
    public static final String INSERT_AUTH_ERROR                                            = "0001";

    public static final String UPDATE_AUTH_ERROR                                            = "0002";

    public static final String UPDATE_AUTH_STATUS_ERROR                                     = "0003";

    public static final String INSERT_ROLE_REPEAT_ERROR                                     = "0004";

    public static final String INSERT_ROLE_ERROR                                            = "0005";

    public static final String UPDATA_ROLE_REPEAT_ERROR                                     = "0006";

    public static final String UPDATE_ROLE_ERROR                                            = "0007";

    public static final String INSERT_ROLE_AUTH_ERROR                                       = "0008";

    public static final String UPDATE_ROLE_STATUS_ERROR                                     = "0009";

    public static final String LOGIN_WITHOUT_PASSWORD_ERROR                                 = "0011";

    public static final String LOGIN_WITHOUT_CODE_ERROR                                     = "0012";

    public static final String LOGIN_CODE_OVER_ERROR                                        = "0013";

    public static final String LOGIN_CODE_WRONG_ERROR                                       = "0014";

    public static final String LOGIN_CODE_WRONG_OUT_ERROR                                   = "0015";

    public static final String LOGIN_USERNAME_WRONG_ERROR                                   = "0016";

    public static final String LOGIN_USERNAME_STATUS_ERROR                                  = "0017";

    public static final String UPDATE_STATUS_CHECK_ROLE_ERROR                               = "0019";

    public static final String UPDATE_STATUS_CHECK_AUTH_ERROR                               = "0020";

    public static final String OLD_PASSWORD_ERROR                                           = "0021";

    public static final String NEW_PASSWORD_NOT_ERROR                                       = "0022";

    public static final String NEW_PASSWORD_ERROR                                           = "0023";

    public static final String UPDATE_PASSWORD_ERROR                                        = "0024";

    public static final String ADD_PRODUCT_CATEGORY_ERROR                                   = "0025";

    public static final String ADD_PRODUCT_CATEGORY_REPEAT_ERROR                            = "0026";

    public static final String LOGIN_WITHOUT_PHONE_ERROR                                    = "0027";

    public static final String LOGIN_PHONE_WRONG_ERROR                                      = "0028";

    public static final String LOGIN_CODE_WRONG_ONE_ERROR                                   = "0029";

    public static final String LOGIN_CODE_WRONG_TWO_ERROR                                   = "0030";

    public static final String REGISTER_USER_ACCOUNT_REPEAT_ERROR                           = "0032";

    public static final String REGISTER_USER_PHONE_REPEAT_ERROR                             = "0033";

    public static final String REGISTER_USE_ERROR                                           = "0034";

    public static final String LOGIN_WITHOUT_ACCOUNT_ERROR                                  = "0035";

    public static final String LOGIN_PASSWORD_WRONG_ONE_ERROR                               = "0037";

    public static final String LOGIN_PASSWORD_WRONG_TWO_ERROR                               = "0038";

    public static final String LOGIN_PASSWORD_WRONG_OUT_ERROR                               = "0039";

    public static final String INSERT_PRODUCT_ATTRIBUTE_CATEGORY_REPEAT_ERROR               = "0040";

    public static final String UPDATE_PRODUCT_CATEGORY_REPEAT_ERROR                         = "0041";

    public static final String UPDATE_PRODUCT_CATEGORY_ERROR                                = "0042";

    public static final String INSERT_PRODUCT_ATTRIBUTE_CATEGORY_ERROR                      = "0043";

    public static final String UPDATE_PRODUCT_ATTRIBUTE_CATEGORY_REPEAT_ERROR               = "0044";

    public static final String UPDATE_PRODUCT_ATTRIBUTE_CATEGORY_ERROR                      = "0045";

    public static final String DELETE_PRODUCT_ATTRIBUTE_CATEGORY_ERROR                      = "0046";

    public static final String INSERT_PRODUCT_ATTRIBUTE_REPEAT_ERROR                        = "0047";

    public static final String INSERT_PRODUCT_ATTRIBUTE_ERROR                               = "0048";

    public static final String UPDATE_PRODUCT_ATTRIBUTE_REPEAT_ERROR                        = "0049";

    public static final String UPDATE_PRODUCT_ATTRIBUTE_ERROR                               = "0050";

    public static final String DELETE_PRODUCT_ATTRIBUTE_ERROR                               = "0051";

    public static final String INSERT_PRODUCT_ERROR                                         = "0052";

    public static final String UPDATE_PRODUCT_ERROR                                         = "0053";

    public static final String DELETE_PRODUCT_ERROR                                         = "0054";

    public static final String INSERT_MEMBER_LEVEL_REPEAT_ERROR                             = "0055";

    public static final String INSERT_MEMBER_LEVEL_ERROR                                    = "0056";

    public static final String UPDATE_MEMBER_LEVEL_REPEAT_ERROR                             = "0057";

    public static final String UPDATE_MEMBER_LEVEL_ERROR                                    = "0058";

    public static final String DELETE_MEMBER_LEVEL_ERROR                                    = "0059";
}
