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
package org.springframework.social.tencentWeibo.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.tencentWeibo.api.TencentWeiboProfileData;

/**
 *
 * @author Gavin.Lin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CompanyMixin extends TencentWeiboObjectMixin {

    @JsonCreator
    CompanyMixin() {
    }
    @JsonProperty("id")
    int id;
    @JsonProperty("begin_year")
    int begin_year;
    @JsonProperty("end_year")
    int end_year;
    @JsonProperty("company_name")
    String company_name;
    @JsonProperty("department_name")
    String department_name;
}
