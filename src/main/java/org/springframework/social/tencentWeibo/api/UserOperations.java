/*
 * Copyright 2014 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.tencentWeibo.api;

/**
 *
 * @author Gavin.Lin
 * @see http://wiki.open.t.qq.com/index.php/API文档#user
 */
public interface UserOperations {

    /**
     * 本接口用于更新用户基本信息，包括出生日期、地区码及个人介绍等。
     *
     * @param format MUST 返回数据的格式（json或xml）
     * @param nick MUST 用户昵称（1-12个中文、字母、数字、下划线或减号）
     * @param sex OPTIONAL 性别（0：未填，1：男，2：女）
     * @param year OPTIONAL 出生年（1900-2010）
     * @param month OPTIONAL 出生月（1-12）
     * @param day OPTIONAL 出生日（1-31）
     * @param countryCode OPTIONAL
     * 国家码（不超过4字节），请参考http://open.t.qq.com//download/addresslist.zip
     * @param provinceCode OPTIONAL
     * 地区码（不超过4字节），请参考http://open.t.qq.com//download/addresslist.zip
     * @param cityCode OPTIONAL
     * 城市码（不超过4字节），请参考http://open.t.qq.com//download/addresslist.zip
     * @param introduction OPTIONAL 个人介绍，不超过140字
     * @see http://wiki.open.t.qq.com/index.php/API文档/帐户接口/更新当前登录用户的个人信息
     */
    void update(String format, String nick, String sex, String year, String month, String day, String countryCode, String provinceCode, String cityCode, String introduction);

    void update(String nick, String sex, String year, String month, String day, String countryCode, String provinceCode, String cityCode, String introduction);

    /**
     * 本接口用于添加、修改或删除用户的教育信息，包括入学年份、学校id等基本信息。
     *
     * @param format MUST 返回数据的格式（json或xml）
     * @param dieldId MUST
     * 教育信息记录id（大于0，添加：feildid=1；修改和删除：fieldid通过调用user/info接口获取，删除：下面四个参数均为空）
     * @param year OPTIONAL 入学年限（1900至今）
     * @param school OPTIONAL 学校id，请参考http://open.t.qq.com/download/edu.zip
     * @param departmentId OPTIONAL
     * 院系id，请参考http://open.t.qq.com/download/edu.zip
     * @param level OPTIONAL 学历，请参考http://open.t.qq.com/download/edu.zip
     * @see http://wiki.open.t.qq.com/index.php/API文档/帐户接口/更新当前登录用户的教育信息
     */
    void updateEdu(String format, String dieldId, String year, String school, String departmentId, String level);

    void updateEdu(String dieldId, String year, String school, String departmentId, String level);

    /**
     * 本接口用于更新用户的头像信息，从而在微博主站显示不同的头像。
     *
     * @param format MUST 返回数据的格式（json或xml）
     * @param file MUST 本地头像图片（最大不超过4M）。文件域表单名，本字段不能放入到签名参数中，不然会出现签名错误
     * @see http://wiki.open.t.qq.com/index.php/API文档/帐户接口/更新当前登录用户的头像信息
     */
    void updateHead(String format, String file);

    void updateHead(String file);

    /**
     * 本接口用于验证用户账号是否合法，根据name或openid验证某个用户是否为合法用户。注意：当name作为请求参数时，请求结果请参照返回字段verify的值，而当fopenid作为请求参数时请求结果请参照返回的错误码
     *
     * @param format MUST 返回数据的格式（json或xml）
     * @param name OPTIONAL 他人的帐户名（可选）
     * @param fopenid OPTIONAL 他人的openid（可选）name和fopenid至少选一个，若同时存在则以name值为主
     * @see http://wiki.open.t.qq.com/index.php/API文档/帐户接口/验证账户的合法性
     */
    void verify(String format, String name, String fopenid);

    void verify(String name, String fopenid);

    /**
     * 本接口用于根据用户账号名及心情类型获取用户发表的心情微博。
     *
     * @param format MUST 返回数据的格式（json或xml）
     * @param name OPTIONAL 他人的帐户名（可选）
     * @param fopenid OPTIONAL 他人的openid（可选）name和fopenid至少选一个，若同时存在则以name值为主
     * @param pageFlag MUST pageflag=0表示回首页
     * pageflag=1表示向下翻页：id和timestamp是上一页的最后一个帖子id和时间(不是根节点)；
     * pageflag=2表示向上翻页：id和timestamp是下一页的第一个帖子id和时间(不是根节点)；
     * @param id MUST 第一次请求填0，后面按照pageflag的说明进行翻页操作
     * @param timestamp MUST 第一次请求填0，后面按照pageflag的说明进行翻页操作
     * @param type OPTIONAL 表示取哪个类型的tweet，按位使用。0x00所有类型 0x1 原创发表 0x2 转载 0x4 私信
     * 0x8 回复 0x10 空回 0x20 提及 0x40 点评
     * @param contentType OPTIONAL 内容过滤，填0表示所有类型 1-带文本(这一位一定有) 2-带链接 4-带图片 8-带视频
     * 0x10-带音频 0x20-微群消息 0x40-带电话录音(IVR语音微博) 0x80-正文非空
     * @param emotionType MUST 自定义标志位，表示取那种心情类型的帖子，按值使用。0xFFFFFFFF表示取所有类型
     * @param reqnum MUST 请求拉取的帖子数（最大不能超过70）
     * @param listType MUST 结果集标识。0-返回每天最后一次的心情列表，1-返回所有心情列表，默认为0
     * @see http://wiki.open.t.qq.com/index.php/API文档/帐户接口/获取用户的心情微博
     */
    void getEmotion(String format, String name, String fopenid, String pageFlag, String id, String timestamp, String type, String contentType, String emotionType, String reqnum, String listType);

    void getEmotion(String name, String fopenid, String pageFlag, String id, String timestamp, String type, String contentType, String emotionType, String reqnum, String listType);

    /**
     * 本接口用于根据用户账号获取用户的详细信息。 1)国家城市名称对应的代码列表 2)教育信息数据库 3)职业ID化列表
     *
     * @param format MUST 返回数据的格式（json或xml）
     * @see http://wiki.open.t.qq.com/index.php/API文档/帐户接口/获取当前登录用户的个人资料
     */
    TencentWeiboProfile getInfo(String format);

    TencentWeiboProfile getInfo();

    /**
     * 本接口用于批量拉取其它用户信息，根据用户账号名或openid获取一批用户的简单资料信息。
     *
     * @param format MUST 返回数据的格式（json或xml）
     * @param names OPTIONAL 用户id列表，用逗号“,”隔开，如 abc,edf,xxxx（最多30，可选）
     * @param fopenids OPTIONAL
     * 你需要读取的用户openid列表，用下划线“_”隔开，例如：B624064BA065E01CB73F835017FE96FA_B624064BA065E01CB73F835017FE96FB（个数与names保持一致，最多30，可选）
     * names和fopenids至少选一个，若同时存在则以names值为主
     * @see http://wiki.open.t.qq.com/index.php/API文档/帐户接口/获取批量用户的个人资料
     */
    void getInfos(String format, String names, String fopenids);

    void getInfos(String names, String fopenids);

    /**
     * 本接口用于拉取某个用户的资料信息，根据用户账号名或openid获取某个用户的简单资料。 1)国家城市名称对应的代码列表 2)教育信息数据库
     * 3)职业ID化列表
     *
     * @param format MUST 返回数据的格式（json或xml）
     * @param name OPTIONAL 他人的帐户名（可选）
     * @param fopenid OPTIONAL 他人的openid（可选）name和fopenid至少选一个，若同时存在则以name值为主
     * @see http://wiki.open.t.qq.com/index.php/API文档/帐户接口/根据用户ID获取用户信息
     */
    void getOtherInfo(String format, String name, String fopenid);

    void getOtherInfo(String name, String fopenid);
}
