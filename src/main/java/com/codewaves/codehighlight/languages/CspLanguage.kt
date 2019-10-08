package com.codewaves.codehighlight.languages

import com.codewaves.codehighlight.core.*

/*
Language = CSP
Description = Content Security Policy definition highlighting 
Author = Taras <oxdef@oxdef.info>

vim = ts=2 sw=2 st=2
*/

/**
 * This class is automatically generated, avoid directly editing it if possible!
 */
class CspLanguage : LanguageBuilder {
    override fun build() = Mode(
        case_insensitive = false,
        lexemes = "[a-zA-Z][a-zA-Z0-9_-]*",

        keywords = listOf(
            Keyword(
                className = "keyword",

                value = "base-uri child-src connect-src default-src font-src form-action frame-ancestors frame-src img-src media-src object-src plugin-types report-uri sandbox script-src style-src"
            )
        ),
        contains = listOf(
            Mode(
                className = "string",

                begin = "'",

                end = "'"
            ),
            Mode(
                className = "attribute",

                begin = "^Content",

                end = ":",

                excludeEnd = true
            )
        )
    )
}
