package com.codewaves.codehighlight.languages

import com.codewaves.codehighlight.core.*

/*
Language = Python
Category = common
*/

/**
 * This class is automatically generated, avoid directly editing it if possible!
 */
class PythonLanguage : LanguageBuilder  {
  val KEYWORDS = listOf(
    Keyword(className = "keyword",

 value = "and elif is global as in if from raise for except finally print import pass return exec else break not with class assert yield try while continue del or def lambda async await nonlocal|10"),
    Keyword(className = "built_in",

 value = "Ellipsis NotImplemented"),
    Keyword(className = "literal",

 value = "False None True"
  ));
  val PROMPT = Mode(
    className = "meta",
  begin = """^(>>>|\.\.\.) """
  );
  val SUBST = Mode(
    className = "subst",

    begin = """\{""",

 end = """\}""",

    keywords = keywords(KEYWORDS),
    illegal = """#"""
  );
  val STRING = Mode(
    className = "string",

    contains = listOf(hljs.BACKSLASH_ESCAPE),
    variants = listOf(
      Mode(
        begin = """(u|b)?r?'''""",

 end = """'''""",

        contains = listOf(hljs.BACKSLASH_ESCAPE, PROMPT),
        relevance = 10
      ),
      Mode(
        begin = """(u|b)?r?"""""",

 end = """"""""",

        contains = listOf(hljs.BACKSLASH_ESCAPE, PROMPT),
        relevance = 10
      ),
      Mode(
        begin = """(fr|rf|f)'''""",

 end = """'''""",

        contains = listOf(hljs.BACKSLASH_ESCAPE, PROMPT, SUBST)
      ),
      Mode(
        begin = """(fr|rf|f)"""""",

 end = """"""""",

        contains = listOf(hljs.BACKSLASH_ESCAPE, PROMPT, SUBST)
      ),
      Mode(
        begin = """(u|r|ur)'""",

 end = """'""",

        relevance = 10
      ),
      Mode(
        begin = """(u|r|ur)"""",

 end = """"""",

        relevance = 10
      ),
      Mode(
        begin = """(b|br)'""",

 end = """'"""
      ),
      Mode(
        begin = """(b|br)"""",

 end = """""""
      ),
      Mode(
        begin = """(fr|rf|f)'""",

 end = """'""",

        contains = listOf(hljs.BACKSLASH_ESCAPE, SUBST)
      ),
      Mode(
        begin = """(fr|rf|f)"""",

 end = """"""",

        contains = listOf(hljs.BACKSLASH_ESCAPE, SUBST)
      ),
      hljs.APOS_STRING_MODE,
      hljs.QUOTE_STRING_MODE
    )
  );
  val NUMBER = Mode(
    className = "number",

 relevance = 0,
    variants = listOf(
      Mode(begin = hljs.BINARY_NUMBER_RE + "[lLjJ]?"),
      Mode(begin = "\\b(0o[0-7]+)[lLjJ]?"),
      Mode(begin = hljs.C_NUMBER_RE + "[lLjJ]?")
    )
  );
  val PARAMS = Mode(
    className = "params",

    begin = """\(""",

 end = """\)""",

    contains = listOf(
 PROMPT, NUMBER, STRING)
  );
  SUBST.contains = listOf(STRING, NUMBER, PROMPT);
  override fun build() = Mode(
    aliases = listOf("py",
 "gyp",
 "ipython"),
    keywords = keywords(KEYWORDS),
    illegal = """(<\/|->|\?)|=>""",

    contains = listOf(
      PROMPT,
      NUMBER,
      STRING,
      hljs.HASH_COMMENT_MODE,
      Mode(
        variants = listOf(
          Mode(className = "function",

 beginKeywords = keywords("def")),
          Mode(className = "class",

 beginKeywords = keywords("class"))
        ),
        end = """:""",

        illegal = """[${'$'}{=;\n,]""",

        contains = listOf(
          hljs.UNDERSCORE_TITLE_MODE,
          PARAMS,
          Mode(
            begin = """->""",

 endsWithParent = true,
            keywords = "None"
          )
        )
      ),
      Mode(
        className = "meta",

        begin = """^[\t ]*@""",

 end = """${'$'}"""
      ),
      Mode(
        begin = """\b(print|exec)\(""" // don’t highlight keywords-turned-functions in Python 3
      )
    )
  );
}
