package ch.deletescape.highlight.languages
import ch.deletescape.highlight.core.*
/*
Language = Clojure
Description = Clojure syntax (based on lisp.js)
Author = mfornos
Contributors = Martin Clausen <martin.clausene@gmail.com>
Category = lisp
*/
/**
 * This function was automatically generated, avoid directly editing it if possible!
 * Origin highlight.js/src/languages/clojure.js MD5 <8c2e940809c0d6be003b78bee3505aef>
 */
internal fun clojure(): Mode {
    var keywords = keyword(
            className = "builtin-name",
            value =
                // Clojure keywords
                "def defonce cond apply if-not if-let if not not= = < > <= >= == + / * - rem quot neg? pos? delay? symbol? keyword? true? false? integer? empty? coll? list? set? ifn? fn? associative? sequential? sorted? counted? reversible? number? decimal? class? distinct? isa? float? rational? reduced? ratio? odd? even? char? seq? vector? string? map? nil? contains? zero? instance? not-every? not-any? libspec? -> ->> .. . inc compare do dotimes mapcat take remove take-while drop letfn drop-last take-last drop-while while intern condp case reduced cycle split-at split-with repeat replicate iterate range merge zipmap declare line-seq sort comparator sort-by dorun doall nthnext nthrest partition eval doseq await await-for let agent atom send send-off release-pending-sends add-watch mapv filterv remove-watch agent-error restart-agent set-error-handler error-handler set-error-mode! error-mode shutdown-agents quote var fn loop recur throw try monitor-enter monitor-exit defmacro defn defn- macroexpand macroexpand-1 for dosync and or when when-not when-let comp juxt partial sequence memoize constantly complement identity assert peek pop doto proxy defstruct first rest cons defprotocol cast coll deftype defrecord last butlast sigs reify second ffirst fnext nfirst nnext defmulti defmethod meta with-meta ns in-ns create-ns import refer keys select-keys vals key val rseq name namespace promise into transient persistent! conj! assoc! dissoc! pop! disj! use class type num float double short byte boolean bigint biginteger bigdec print-method print-dup throw-if printf format load compile get-in update-in pr pr-on newline flush read slurp read-line subvec with-open memfn time re-find re-groups rand-int rand mod locking assert-valid-fdecl alias resolve ref deref refset swap! reset! set-validator! compare-and-set! alter-meta! reset-meta! commute get-validator alter ref-set ref-history-count ref-min-history ref-max-history ensure sync io! new next conj set! to-array future future-call into-array aset gen-class reduce map filter find empty hash-map hash-set sorted-map sorted-map-by sorted-set sorted-set-by vec vector seq flatten reverse assoc dissoc list disj get union difference intersection extend extend-type extend-protocol int nth delay count concat chunk chunk-buffer chunk-append chunk-first chunk-rest max min dec unchecked-inc-int unchecked-inc unchecked-dec-inc unchecked-dec unchecked-negate unchecked-add-int unchecked-add unchecked-subtract-int unchecked-subtract chunk-next chunk-cons chunked-seq? prn vary-meta lazy-seq spread list* str find-keyword keyword symbol gensym force rationalize"
        )
    var SYMBOLSTART = "a-zA-Z_\\-!.?+*=<>&#'"
    var SYMBOL_RE = "[" +
        SYMBOLSTART + "][" +
        SYMBOLSTART + "0-9/;:]*"
    var SIMPLE_NUMBER_RE = "[-+]?\\d+(\\.\\d+)?"
    var SYMBOL = Mode(
        begin = SYMBOL_RE,
        relevance = 0
    )
    var NUMBER = Mode(
        className = "number",
        begin = SIMPLE_NUMBER_RE,
        relevance = 0
    )
    var STRING = hljs.inherit(hljs.QUOTE_STRING_MODE, Mode(illegal = null))
    var COMMENT = hljs.COMMENT(
        ";",
        "$",
        Mode(
            relevance = 0
        )
    )
    var LITERAL = Mode(
        className = "literal",
        begin =
            """\b(true|false|nil)\b"""
    )
    var COLLECTION = Mode(
        begin = "[\\[\\\\{]",
        end = "[\\]\\}]"
    )
    var HINT = Mode(
        className = "comment",
        begin = "\\^" +
            SYMBOL_RE
    )
    var HINT_COL = hljs.COMMENT(
        "\\^\\{",
        "\\}"
    )
    var KEY = Mode(
        className = "symbol",
        begin = "[:]{1,2}" +
            SYMBOL_RE
    )
    var LIST = Mode(
        begin = "\\(",
        end = "\\)"
    )
    var BODY = Mode(
        endsWithParent = true,
        relevance = 0
    )
    var NAME = Mode(
        keywords = keywords,
        lexemes = SYMBOL_RE,
        className = "name",
        begin = SYMBOL_RE,
        starts = BODY
    )
    var DEFAULT_CONTAINS = listOf(LIST, STRING, HINT, HINT_COL, COMMENT, KEY, COLLECTION, NUMBER, LITERAL, SYMBOL)
    LIST.contains = listOf(
        hljs.COMMENT(
            "comment",
            ""
        ),
        NAME, BODY
    )
    BODY.contains = DEFAULT_CONTAINS
    COLLECTION.contains = DEFAULT_CONTAINS
    HINT_COL.contains = listOf(COLLECTION)
    return Mode(
        aliases = listOf("clj"),
        illegal =
            """\S""",
        contains = listOf(LIST, STRING, HINT, HINT_COL, COMMENT, KEY, COLLECTION, NUMBER, LITERAL)
    )
}
