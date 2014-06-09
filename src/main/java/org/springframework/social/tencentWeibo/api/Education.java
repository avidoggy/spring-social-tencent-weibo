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
public class Education {
//departmentid : 院系id,
//id : 教育信息记录id,
//level : 学历级别,
//schoolid : 学校id,
//year : 入学年

    private int departmentid;
    private int id;
    private int level;
    private int schoolid;
    private int year;

    /**
     * @return the departmentid
     */
    public int getDepartmentid() {
        return departmentid;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return the schoolid
     */
    public int getSchoolid() {
        return schoolid;
    }

    /**
     * @return the year
     */
    public int getYear() {
        return year;
    }
}
