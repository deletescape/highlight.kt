package ch.deletescape.highlight.languages
import ch.deletescape.highlight.core.*
/*
Language = Markdown
Requires = xml.js
Author = John Crepezzi <john.crepezzi@gmail.com>
Website = http = //seejohncode.com/
Category = common, markup
*/
/**
 * This function was automatically generated, avoid directly editing it if possible!
 * Origin highlight.js/src/languages/markdown.js MD5 <9c568504b931710b0eb4a9202c3f107f>
 */
internal fun markdown(): Mode {
    return Mode(
        aliases = listOf(
            "md",
            "mkdown",
            "mkd"
        ),
        contains = listOf(
            // highlight headers
            Mode(
                className = "section",
                variants = listOf(
                    Mode(
                        begin = "^#{1,6}",
                        end = "$"
                    ),
                    Mode(begin = "^.+?\\n[=-]{2,}\$")
                )
            ),
            // inline html
            Mode(
                begin = "<",
                end = ">",
                subLanguage = "xml",
                relevance = 0
            ),
            // lists (indicators only)
            Mode(
                className = "bullet",
                begin = "^\\s*([*+-]|(\\d+\\.))\\s+"
            ),
            // strong segments
            Mode(
                className = "strong",
                begin = "[*_]{2}.+?[*_]{2}"
            ),
            // emphasis segments
            Mode(
                className = "emphasis",
                variants = listOf(
                    Mode(begin = "\\*.+?\\*"),
                    Mode(
                        begin = "_.+?_",
                        relevance = 0
                    )
                )
            ),
            // blockquotes
            Mode(
                className = "quote",
                begin = "^>\\s+",
                end = "$"
            ),
            // code snippets
            Mode(
                className = "code",
                variants = listOf(
                    Mode(
                        begin = "^```\\w*\\s*\$",
                        end = "^```[ ]*\$"
                    ),
                    Mode(
                        begin = "`.+?`"
                    ),
                    Mode(
                        begin = "^( {4}|\\t)",
                        end = "$",
                        relevance = 0
                    )
                )
            ),
            // horizontal rules
            Mode(
                begin = "^[-\\*]{3,}",
                end = "$"
            ),
            // using links - title and link
            Mode(
                begin = "\\[.+?\\][\\(\\[].*?[\\)\\]]",
                returnBegin = true,
                contains = listOf(
                    Mode(
                        className = "string",
                        begin = "\\[",
                        end = "\\]",
                        excludeBegin = true,
                        returnEnd = true,
                        relevance = 0
                    ),
                    Mode(
                        className = "link",
                        begin = "\\]\\(",
                        end = "\\)",
                        excludeBegin = true,
                        excludeEnd = true
                    ),
                    Mode(
                        className = "symbol",
                        begin = "\\]\\[",
                        end = "\\]",
                        excludeBegin = true,
                        excludeEnd = true
                    )
                ),
                relevance = 10
            ),
            Mode(
                begin =
                    """^\[[^\n]+\]:""",
                returnBegin = true,
                contains = listOf(
                    Mode(
                        className = "symbol",
                        begin =
                            """\[""",
                        end =
                            """\]""",
                        excludeBegin = true,
                        excludeEnd = true
                    ),
                    Mode(
                        className = "link",
                        begin =
                            """:\s*""",
                        end =
                            """${'$'}""",
                        excludeBegin = true
                    )
                )
            )
        )
    )
}
