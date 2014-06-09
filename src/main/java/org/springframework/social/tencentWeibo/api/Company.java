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
 */
public class Company {
//begin_year : 开始年 ,
//company_name : 公司名称 ,
//department_name : 部门名称 ,
//end_year : 结束年 ,
//id : 公司id

    private int id;
    private int begin_year;
    private int end_year;
    private String company_name;
    private String department_name;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the begin_year
     */
    public int getBegin_year() {
        return begin_year;
    }

    /**
     * @return the end_year
     */
    public int getEnd_year() {
        return end_year;
    }

    /**
     * @return the company_name
     */
    public String getCompany_name() {
        return company_name;
    }

    /**
     * @return the department_name
     */
    public String getDepartment_name() {
        return department_name;
    }
}
