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

import com.fasterxml.jackson.databind.module.SimpleModule;
import org.springframework.social.tencentWeibo.api.Company;
import org.springframework.social.tencentWeibo.api.Education;
import org.springframework.social.tencentWeibo.api.TencentWeiboProfile;
import org.springframework.social.tencentWeibo.api.TencentWeiboProfileData;

/**
 * Jackson module for setting up mixin annotations on TencentWeibo model types. This enables the use of Jackson annotations without
 * directly annotating the model classes themselves.
 * @author Gavin.Lin
 */
public class TencentWeiboModule extends SimpleModule {

    private static final long serialVersionUID = 1L;

    public TencentWeiboModule() {
        super("TencentWeiboModule");
    }

    @Override
    public void setupModule(SetupContext context) {
        context.setMixInAnnotations(TencentWeiboProfile.class, TencentWeiboProfileMixin.class);
        context.setMixInAnnotations(TencentWeiboProfileData.class, TencentWeiboProfileDataMixin.class);
        context.setMixInAnnotations(Education.class, EducationMixin.class);
        context.setMixInAnnotations(Company.class, CompanyMixin.class);
    }
}
