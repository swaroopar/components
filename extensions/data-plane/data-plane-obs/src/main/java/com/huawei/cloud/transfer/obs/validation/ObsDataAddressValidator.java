/*
 *  Copyright (c) 2024 Huawei Technologies
 *
 *  This program and the accompanying materials are made available under the
 *  terms of the Apache License, Version 2.0 which is available at
 *  https://www.apache.org/licenses/LICENSE-2.0
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  Contributors:
 *       Huawei Technologies - initial API and implementation
 *
 */

package com.huawei.cloud.transfer.obs.validation;

import org.eclipse.edc.spi.types.domain.DataAddress;
import org.eclipse.edc.util.string.StringUtils;
import org.eclipse.edc.validator.spi.ValidationResult;
import org.eclipse.edc.validator.spi.Validator;
import org.eclipse.edc.validator.spi.Violation;

import static com.huawei.cloud.obs.ObsBucketSchema.BUCKET_NAME;
import static com.huawei.cloud.obs.ObsBucketSchema.ENDPOINT;

public class ObsDataAddressValidator implements Validator<DataAddress> {
    @Override
    public ValidationResult validate(DataAddress input) {
        if (StringUtils.isNullOrBlank(input.getStringProperty(BUCKET_NAME, null))) {
            return ValidationResult.failure(Violation.violation("Must contain property '%s'".formatted(BUCKET_NAME), BUCKET_NAME));
        }
        if (StringUtils.isNullOrBlank(input.getStringProperty(ENDPOINT, null))) {
            return ValidationResult.failure(Violation.violation("Must contain property '%s'".formatted(ENDPOINT), ENDPOINT));
        }
        return ValidationResult.success();
    }
}
