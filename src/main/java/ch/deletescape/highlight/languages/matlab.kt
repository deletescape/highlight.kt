package ch.deletescape.highlight.languages
import ch.deletescape.highlight.core.*
/*
Language = Matlab
Author = Denis Bardadym <bardadymchik@gmail.com>
Contributors = Eugene Nizhibitsky <nizhibitsky@ya.ru>, Egor Rogov <e.rogov@postgrespro.ru>
Category = scientific
*/
/*
  Formal syntax is not published, helpful link = 
  https = //github.com/kornilova-l/matlab-IntelliJ-plugin/blob/master/src/main/grammar/Matlab.bnf
*/
/**
 * This function was automatically generated, avoid directly editing it if possible!
 * Origin highlight.js/src/languages/matlab.js MD5 <d5904e3885b0430bb642ba7faebb2c18>
 */
internal fun matlab(): Mode {
    var TRANSPOSE_RE = "('|\\.')+"
    var TRANSPOSE = Mode(
        relevance = 0,
        contains = listOf(
            Mode(begin = TRANSPOSE_RE)
        )
    )
    return Mode(
        keywords = listOf(
            keyword(
                className = "keyword",
                value =
                    "break case catch classdef continue else elseif end enumerated events for function global if methods otherwise parfor persistent properties return spmd switch try while"
            ),
            keyword(
                className = "built_in",
                value =
                    "sin sind sinh asin asind asinh cos cosd cosh acos acosd acosh tan tand tanh atan atand atan2 atanh sec secd sech asec asecd asech csc cscd csch acsc acscd acsch cot cotd coth acot acotd acoth hypot exp expm1 log log1p log10 log2 pow2 realpow reallog realsqrt sqrt nthroot nextpow2 abs angle complex conj imag real unwrap isreal cplxpair fix floor ceil round mod rem sign airy besselj bessely besselh besseli besselk beta betainc betaln ellipj ellipke erf erfc erfcx erfinv expint gamma gammainc gammaln psi legendre cross dot factor isprime primes gcd lcm rat rats perms nchoosek factorial cart2sph cart2pol pol2cart sph2cart hsv2rgb rgb2hsv zeros ones eye repmat rand randn linspace logspace freqspace meshgrid accumarray size length ndims numel disp isempty isequal isequalwithequalnans cat reshape diag blkdiag tril triu fliplr flipud flipdim rot90 find sub2ind ind2sub bsxfun ndgrid permute ipermute shiftdim circshift squeeze isscalar isvector ans eps realmax realmin pi i inf nan isnan isinf isfinite j why compan gallery hadamard hankel hilb invhilb magic pascal rosser toeplitz vander wilkinson max min nanmax nanmin mean nanmean type table readtable writetable sortrows sort figure plot plot3 scatter scatter3 cellfun legend intersect ismember procrustes hold num2cell "
            )
        ).flatten(),
        illegal = "(//|\"|#|/\\*|\\s+/\\w+)",
        contains = listOf(
            Mode(
                className = "function",
                beginKeywords = keywords("function"),
                end = "$",
                contains = listOf(
                    hljs.UNDERSCORE_TITLE_MODE,
                    Mode(
                        className = "params",
                        variants = listOf(
                            Mode(
                                begin = "\\(",
                                end = "\\)"
                            ),
                            Mode(
                                begin = "\\[",
                                end = "\\]"
                            )
                        )
                    )
                )
            ),
            Mode(
                className = "built_in",
                begin =
                    """true|false""",
                relevance = 0,
                starts = TRANSPOSE
            ),
            Mode(
                begin = "[a-zA-Z][a-zA-Z_0-9]*" +
                    TRANSPOSE_RE,
                relevance = 0
            ),
            Mode(
                className = "number",
                begin = hljs.C_NUMBER_RE,
                relevance = 0,
                starts = TRANSPOSE
            ),
            Mode(
                className = "string",
                begin = "'",
                end = "'",
                contains = listOf(
                    hljs.BACKSLASH_ESCAPE,
                    Mode(begin = "''")
                )
            ),
            Mode(
                begin =
                    """\]|}|\)""",
                relevance = 0,
                starts = TRANSPOSE
            ),
            Mode(
                className = "string",
                begin = "\"",
                end = "\"",
                contains = listOf(
                    hljs.BACKSLASH_ESCAPE,
                    Mode(begin = "\"\"")
                ),
                starts = TRANSPOSE
            ),
            hljs.COMMENT(
                "^\\s*\\%\\\\\\{\\s*\$",
                "^\\s*\\%\\}\\s*\$"
            ),
            hljs.COMMENT(
                "\\%",
                "$"
            )
        )
    )
}
