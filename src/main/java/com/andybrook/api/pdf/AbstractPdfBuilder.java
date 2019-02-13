package com.andybrook.api.pdf;

import com.andybrook.language.LanguageResolver;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractPdfBuilder {

    @Autowired
    protected LanguageResolver languageResolver;
}
