package com.training.ykb.rest.custom.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class StartWithCheck implements ConstraintValidator<StartWith, String> {

    private StartWith ano;

    @Override
    public void initialize(final StartWith anoParam) {
        this.ano = anoParam;
    }

    @Override
    public boolean isValid(final String valueParam,
                           final ConstraintValidatorContext contextParam) {
        return valueParam.startsWith(this.ano.value());
    }

}
