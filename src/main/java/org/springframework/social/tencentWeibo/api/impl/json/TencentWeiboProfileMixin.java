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
 * Annotated mixin to add Jackson annotations to TencentWeiboProfile.
 *
 * @author Gavin.Lin
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class TencentWeiboProfileMixin extends TencentWeiboObjectMixin {

    @JsonCreator
    TencentWeiboProfileMixin(
            @JsonProperty("errcode") int errcode,
            @JsonProperty("msg") String msg,
            @JsonProperty("ret") int ret) {
    }
    @JsonProperty("data")
    TencentWeiboProfileData data;
    @JsonProperty("seqid")
    long seqid;
}