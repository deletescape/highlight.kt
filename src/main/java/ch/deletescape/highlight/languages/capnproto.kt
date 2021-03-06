package ch.deletescape.highlight.languages
import ch.deletescape.highlight.core.*
/*
Language = Cap’n Proto
Author = Oleg Efimov <efimovov@gmail.com>
Description = Cap’n Proto message definition format
Category = protocols
*/
/**
 * This function was automatically generated, avoid directly editing it if possible!
 * Origin highlight.js/src/languages/capnproto.js MD5 <a5786b28f406222dc180b6d5656ecd6d>
 */
internal fun capnproto(): Mode {
    return Mode(
        aliases = listOf("capnp"),
        keywords = listOf(
            keyword(
                className = "keyword",
                value =
                    "struct enum interface union group import using const annotation extends in of on as with from fixed"
            ),
            keyword(
                className = "built_in",
                value =
                    "Void Bool Int8 Int16 Int32 Int64 UInt8 UInt16 UInt32 UInt64 Float32 Float64 Text Data AnyPointer AnyStruct Capability List"
            ),
            keyword(
                className = "literal",
                value =
                    "true false"
            )
        ).flatten(),
        contains = listOf(
            hljs.QUOTE_STRING_MODE,
            hljs.NUMBER_MODE,
            hljs.HASH_COMMENT_MODE,
            Mode(
                className = "meta",
                begin =
                    """@0x[\w\d]{16};""",
                illegal =
                    """\n"""
            ),
            Mode(
                className = "symbol",
                begin =
                    """@\d+\b"""
            ),
            Mode(
                className = "class",
                beginKeywords = keywords("struct enum"),
                end =
                    """\{""",
                illegal =
                    """\n""",
                contains = listOf(
                    hljs.inherit(
                        hljs.TITLE_MODE,
                        Mode(
                            starts = Mode(
                                endsWithParent = true,
                                excludeEnd = true
                            ) // hack: eating everything after the first title
                        )
                    )
                )
            ),
            Mode(
                className = "class",
                beginKeywords = keywords("interface"),
                end =
                    """\{""",
                illegal =
                    """\n""",
                contains = listOf(
                    hljs.inherit(
                        hljs.TITLE_MODE,
                        Mode(
                            starts = Mode(
                                endsWithParent = true,
                                excludeEnd = true
                            ) // hack: eating everything after the first title
                        )
                    )
                )
            )
        )
    )
}
