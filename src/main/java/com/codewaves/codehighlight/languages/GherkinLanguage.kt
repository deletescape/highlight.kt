package com.codewaves.codehighlight.languages

import com.codewaves.codehighlight.core.*

/*
 Language = Gherkin
 Author = Sam Pikesley (@pikesley) <sam.pikesley@theodi.org>
 Description = Gherkin (Cucumber etc)
 */

/**
 * This class is automatically generated, avoid directly editing it if possible!
 */
class GherkinLanguage : LanguageBuilder {
    override fun build() = Mode(
        aliases = listOf("feature"),
        keywords = keywords("Feature Background Ability Business\ Need Scenario Scenarios Scenario\ Outline Scenario\ Template Examples Given And Then But When"),
        contains = listOf(
            Mode(
                className = "symbol",

                begin = "\\*",

                relevance = 0
            ),
            Mode(
                className = "meta",

                begin = "@[^@\\s]+"
            ),
            Mode(
                begin = "\\|",

                end = "\\|\\w*\$",

                contains = listOf(
                    Mode(
                        className = "string",

                        begin = "[^|]+"
                    )
                )
            ),
            Mode(
                className = "variable",

                begin = "<",

                end = ">"
            ),
            hljs.HASH_COMMENT_MODE,
            Mode(
                className = "string",

                begin = "\"\"\"",

                end = "\"\"\""
            ),
            hljs.QUOTE_STRING_MODE
        )
    )
}
