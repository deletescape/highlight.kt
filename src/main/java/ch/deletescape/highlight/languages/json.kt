package ch.deletescape.highlight.languages

import ch.deletescape.highlight.core.Mode
import ch.deletescape.highlight.core.hljs
import ch.deletescape.highlight.core.keyword
import ch.deletescape.highlight.core.keywords

/*
Language = JSON / JSON with Comments
Author = Ivan Sagalaev <maniac@softwaremaniacs.org>
Category = common, protocols
*/
/**
 * This function was automatically generated, avoid directly editing it if possible!
 * Origin highlight.js/src/languages/json.js MD5 <e7c66d259be22095e1900dee8845b531>
 */
internal fun json(): Mode {
    var LITERALS = keyword(
        className = "literal",
        value = "true false null"
    )
    var ALLOWED_COMMENTS = listOf(
        hljs.C_LINE_COMMENT_MODE,
        hljs.C_BLOCK_COMMENT_MODE
    )
    val TYPES = mutableListOf(
        hljs.QUOTE_STRING_MODE,
        hljs.C_NUMBER_MODE
    )

    var VALUE_CONTAINER = Mode(
        end = ",",
        endsWithParent = true,
        excludeEnd = true,
        contains = TYPES,
        keywords = LITERALS
    )
    var OBJECT = Mode(
        begin = "\\{",
        end = "\\}",
        contains = listOf(
            Mode(
                className = "attr",
                begin =
                """"""",
                end =
                """"""",
                contains = listOf(hljs.BACKSLASH_ESCAPE),
                illegal = "\\n"
            ),
            hljs.inherit(
                VALUE_CONTAINER, Mode(
                    begin =
                    """:"""
                )
            )
        ) + ALLOWED_COMMENTS,
        illegal = "\\S"
    )
    var ARRAY = Mode(
        begin = "\\[",
        end = "\\]",
        contains = listOf(VALUE_CONTAINER), // inherit is a workaround for a bug that makes shared modes with endsWithParent compile only the ending of one of the parents
        illegal = "\\S"
    )
    TYPES += listOf(OBJECT, ARRAY)
    ALLOWED_COMMENTS.forEach { rule ->
        TYPES += listOf(rule)
    }
    return Mode(
        contains = TYPES,
        keywords = LITERALS,
        illegal = "\\S"
    )
}
