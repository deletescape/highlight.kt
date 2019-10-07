package com.codewaves.codehighlight.languages

import com.codewaves.codehighlight.core.LanguageBuilder
import com.codewaves.codehighlight.core.Mode
import com.codewaves.codehighlight.core.hljs
import com.codewaves.codehighlight.core.keywords

/*
Language = CSS
Category = common, css
*/

/**
 * This class is automatically generated, avoid directly editing it if possible!
 */
class CssLanguage : LanguageBuilder {
    val IDENT_RE = "[a-zA-Z-][a-zA-Z0-9_-]*"
    val RULE = Mode(
        begin = """(?:[A-Z\_\.\-]+|--[a-zA-Z0-9_-]+)\s*:""",
        returnBegin = true,
        end = ";",
        endsWithParent = true,
        contains = listOf(
            Mode(
                className = "attribute",
                begin = """\S""",
                end = ":",
                excludeEnd = true,
                starts = Mode(
                    endsWithParent = true,
                    excludeEnd = true,
                    contains = listOf(
                        Mode(
                            begin = """[\w-]+\(""",
                            returnBegin = true,
                            contains = listOf(
                                Mode(
                                    className = "built_in",
                                    begin = """[\w-]+"""
                                ),
                                Mode(
                                    begin = """\(""",
                                    end = """\)""",
                                    contains = listOf(
                                        hljs.APOS_STRING_MODE,
                                        hljs.QUOTE_STRING_MODE
                                    )
                                )
                            )
                        ),
                        hljs.CSS_NUMBER_MODE,
                        hljs.QUOTE_STRING_MODE,
                        hljs.APOS_STRING_MODE,
                        hljs.C_BLOCK_COMMENT_MODE,
                        Mode(
                            className = "number",
                            begin = "#[0-9A-Fa-f]+"
                        ),
                        Mode(
                            className = "meta",
                            begin = "!important"
                        )
                    )
                )
            )
        )
    )

    override fun build() = Mode(
        case_insensitive = true,
        illegal = """[=\/|'\${'$'}]""",
        contains = listOf(
            hljs.C_BLOCK_COMMENT_MODE,
            Mode(
                className = "selector-id",
                begin = """#[A-Za-z0-9_-]+"""
            ),
            Mode(
                className = "selector-class",
                begin = """\.[A-Za-z0-9_-]+"""
            ),
            Mode(
                className = "selector-attr",
                begin = """\[""",
                end = """\]""",
                illegal = "${'$'}"
            ),
            Mode(
                className = "selector-pseudo",
                begin = """:(:)?[a-zA-Z0-9\_\-\+\(\)"'.]+"""
            ),
            Mode(
                begin = "@(font-face|page)",
                lexemes = "[a-z-]+",
                keywords = keywords("font-face page")
            ),
            Mode(
                begin = "@",
                end = "[{;]", // at_rule eating first "{" is a good thing
                // because it doesn’t let it to be parsed as
                // a rule set but instead drops parser into
                // the default mode which is how it should be.
                illegal = """:""", // break on Less variables @var = ...
                contains = listOf(
                    Mode(
                        className = "keyword",
                        begin = """\w+"""
                    ),
                    Mode(
                        begin = """\s""",
                        endsWithParent = true,
                        excludeEnd = true,
                        relevance = 0,
                        contains = listOf(
                            hljs.APOS_STRING_MODE, hljs.QUOTE_STRING_MODE,
                            hljs.CSS_NUMBER_MODE
                        )
                    )
                )
            ),
            Mode(
                className = "selector-tag",
                begin = IDENT_RE,
                relevance = 0
            ),
            Mode(
                begin = "{",
                end = "}",
                illegal = """\S""",
                contains = listOf(
                    hljs.C_BLOCK_COMMENT_MODE,
                    RULE
                )
            )
        )
    )
}
