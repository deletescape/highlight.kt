package com.codewaves.codehighlight.languages

import com.codewaves.codehighlight.core.*

/*
Language = crmsh
Author = Kristoffer Gronlund <kgronlund@suse.com>
Website = http://crmsh.github.io
Description = Syntax Highlighting for the crmsh DSL
Category = config
*/

/**
 * This class is automatically generated, avoid directly editing it if possible!
 */
class CrmshLanguage : LanguageBuilder  {
  val RESOURCES = "primitive rsc_template";

  val COMMANDS = "group clone ms master location colocation order fencing_topology rsc_ticket acl_target acl_group user role tag xml";

  val PROPERTY_SETS = "property rsc_defaults op_defaults";

  val KEYWORDS = "params meta operations op rule attributes utilization";

  val OPERATORS = "read write deny defined not_defined in_range date spec in ref reference attribute type xpath version and or lt gt tag lte gte eq ne \\";

  val TYPES = "number string";

  val LITERALS = "Master Started Slave Stopped start promote demote stop monitor true false";

  override fun build() = Mode(
    aliases = listOf("crm",
 "pcmk"),
    case_insensitive = true,
    keywords = listOf(
      Keyword(className = "keyword",

 value = KEYWORDS + " " +
 OPERATORS + " " +
 TYPES),
      Keyword(className = "literal",

 value = LITERALS
    )),
    contains = listOf(
      hljs.HASH_COMMENT_MODE,
      Mode(
        beginKeywords = keywords("node"),
        starts = Mode(
          end = "\\s*(listOf(\\w_-]+:)?",

          starts = Mode(
            className = "title",

            end = "\\s*[\\$\\w_][\\w_-]*"
          )
        )
      ),
      Mode(
        beginKeywords = keywords(RESOURCES),
        starts = Mode(
          className = "title",

          end = "\\s*[\\$\\w_][\\w_-]*",

          starts = Mode(
            end = "\\s*@?[\\w_][\\w_\\.:-]*"
          )
        )
      ),
      Mode(
        begin = "\\b(" +
 COMMANDS.split(" \").joinToString(\"|\") + \")\\s+",

        keywords = keywords(COMMANDS),
        starts = Mode(
          className = "title",

          end = "[\\$\\w_][\\w_-]*"
        )
      ),
      Mode(
        beginKeywords = keywords(PROPERTY_SETS),
        starts = Mode(
          className = "title",

          end = "\\s*(listOf(\\w_-]+:)?"
        )
      ),
      hljs.QUOTE_STRING_MODE,
      Mode(
        className = "meta",

        begin = "(ocf|systemd|service|lsb):[\\w_:-]+",

        relevance = 0
      ),
      Mode(
        className = "number",

        begin = "\\b\\d+(\\.\\d+)?(ms|s|h|m)?",

        relevance = 0
      ),
      Mode(
        className = "literal",

        begin = "[-]?(infinity|inf)",

        relevance = 0
      ),
      Mode(
        className = "attr",

        begin = """(listOf(A-Za-z\${'$'}_\#][\w_-]+)=""",

        relevance = 0
      ),
      Mode(
        className = "tag",

        begin = "</?",

        end = "/?>",

        relevance = 0
      )
    )
  );
}
