package
parse
;
import
java
.
util
.
List
;
import
errorMsg
.
*
;
import
syntaxtree
.
*
;
import
wrangLR
.
runtime
.
MessageObject
;
import
wrangLR
.
runtime
.
FilePosObject
;
public class MJGrammarParseTable implements wrangLR.runtime.ParseTable {
public int getEofSym() { return 110; }
public int getNttSym() { return 111; }
private String[] symNameTable = {
"$$start",
"<start>",
"ws*",
"<program>",
"<class decl>+",
"<class decl>",
"`class",
"ID",
"`{",
"<decl in class>*",
"`}",
"<decl in class>",
"<method decl>",
"`public",
"`void",
"`(",
"`)",
"<stmt>*",
"<type>",
"`int",
"`boolean",
"<empty bracket pair>",
"`[",
"`]",
"<stmt>",
"<assign>",
"`;",
"<local var decl>",
"<expr>",
"`=",
"<expr8>",
"`||",
"<expr7>",
"`&&",
"<expr6>",
"`==",
"<expr5>",
"`!=",
"`<",
"<expr4>",
"`>",
"`<=",
"`>=",
"`instanceof",
"`+",
"<expr3>",
"`-",
"`*",
"<expr2>",
"`/",
"`%",
"<cast expr>",
"<expr1>",
"<unary expr>",
"INTLIT",
"letter",
"\"p\"",
"\"v\"",
"{\"A\"..\"Z\" \"a\" \"d\"..\"h\" \"j\"..\"k\" \"m\" \"q\"..\"s\" \"w\"..\"z\"}",
"\"c\"",
"\"i\"",
"\"l\"",
"\"o\"",
"\"u\"",
"\"b\"",
"\"n\"",
"\"t\"",
"letter128",
"{199..218 231..250}",
"{193..198 225..230}",
"digit",
"{\"1\"..\"9\"}",
"\"0\"",
"digit128",
"{176..185}",
"ws",
"\" \"",
"10",
"\"#\"",
"\"@\"",
"\"!\"",
"\"%\"",
"\"&\"",
"\"*\"",
"\"(\"",
"\")\"",
"\"{\"",
"\"}\"",
"\"-\"",
"\"+\"",
"\"=\"",
"\"[\"",
"\"]\"",
"\"|\"",
"\"<\"",
"\">\"",
"\";\"",
"\"/\"",
"idChar*",
"$$0",
"digit*",
"$$1",
"hexDigit*",
"$$2",
"idChar",
"\"_\"",
"idChar128",
"223",
"hexDigit",
"hexDigit128",
"$",
"$NT",
};
public String symName(int n) {
 return n >= 0 && n < symNameTable.length ? symNameTable[n] : "??";
}
private MJGrammar actionObject;
public int[][] getParseTable() { return parseTable; }
public int numSymbols() { return 112;}
private static final int MIN_REDUCTION = 853;
public int minReduction() { return MIN_REDUCTION;}
private static final int MAX_ACCEPT_REDUCTION = MIN_REDUCTION+0;
public int maxAcceptReduction() { return MAX_ACCEPT_REDUCTION; }
private final int[][] parseTable;
public void error(int pos, String msg){
 if (((Object)actionObject) instanceof wrangLR.runtime.MessageObject)
 ((wrangLR.runtime.MessageObject)(Object)actionObject).error(pos,msg);
 else System.err.println("file position "+pos+": "+msg);}
public void warning(int pos, String msg){
 if (((Object)actionObject) instanceof wrangLR.runtime.MessageObject)
 ((wrangLR.runtime.MessageObject)(Object)actionObject).warning(pos,msg);
 else System.err.println("file position "+pos+"(warning): "+msg);}
public String filePosString(int pos){
 if (((Object)actionObject) instanceof wrangLR.runtime.FilePosObject)
 return ((wrangLR.runtime.FilePosObject)(Object)actionObject).filePosString(pos);
 else return ""+pos;}
public boolean parse(java.io.InputStream is) {
	return new wrangLR.runtime.BaseParser(this).parse(is);
}
public boolean parse(java.io.InputStream is, int verboseLevel, boolean verboseReductions) {
	return new wrangLR.runtime.BaseParser(this,verboseLevel,verboseReductions).parse(is);
}
private class Initter1{
public int doInit(int startIdx) {
  for (int i = 0; i < myParseTable.length; i++) {
    parseTable[i+startIdx] = myParseTable[i];
  }
  return myParseTable.length;
}
private final int[][] myParseTable = {
{ // state 0
1,366, // <start>
2,537, // ws*
3,290, // <program>
4,255, // <class decl>+
5,673, // <class decl>
6,676, // `class
75,300, // ws
76,507, // " "
77,442, // {10}
78,132, // "#"
  }
,
{ // state 1
  }
,
{ // state 2
0x80000000|1, // match move
0x80000000|604, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 3
22,MIN_REDUCTION+114, // `[
91,MIN_REDUCTION+114, // "["
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 4
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 5
75,189, // ws
76,349, // " "
77,13, // {10}
MIN_REDUCTION+95, // (default reduction)
  }
,
{ // state 6
7,139, // ID
18,285, // <type>
19,325, // `int
20,253, // `boolean
55,241, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,270, // letter128
68,579, // {199..218 231..250}
69,579, // {193..198 225..230}
78,328, // "#"
  }
,
{ // state 7
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 8
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 9
2,419, // ws*
75,276, // ws
76,794, // " "
77,613, // {10}
MIN_REDUCTION+60, // (default reduction)
  }
,
{ // state 10
38,615, // `<
40,385, // `>
41,75, // `<=
42,348, // `>=
43,112, // `instanceof
78,83, // "#"
79,162, // "@"
94,815, // "<"
95,314, // ">"
MIN_REDUCTION+25, // (default reduction)
  }
,
{ // state 11
75,327, // ws
76,450, // " "
77,497, // {10}
MIN_REDUCTION+73, // (default reduction)
  }
,
{ // state 12
2,398, // ws*
75,592, // ws
76,628, // " "
77,781, // {10}
MIN_REDUCTION+102, // (default reduction)
  }
,
{ // state 13
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 14
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 15
22,MIN_REDUCTION+119, // `[
91,MIN_REDUCTION+119, // "["
MIN_REDUCTION+119, // (default reduction)
  }
,
{ // state 16
22,MIN_REDUCTION+119, // `[
91,MIN_REDUCTION+119, // "["
MIN_REDUCTION+119, // (default reduction)
  }
,
{ // state 17
75,330, // ws
76,587, // " "
77,417, // {10}
MIN_REDUCTION+81, // (default reduction)
  }
,
{ // state 18
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 19
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 20
2,747, // ws*
75,647, // ws
76,39, // " "
77,109, // {10}
MIN_REDUCTION+88, // (default reduction)
  }
,
{ // state 21
22,695, // `[
91,712, // "["
  }
,
{ // state 22
111,MIN_REDUCTION+142, // $NT
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 23
2,603, // ws*
22,MIN_REDUCTION+96, // `[
75,743, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+96, // "["
MIN_REDUCTION+96, // (default reduction)
  }
,
{ // state 24
56,658, // "p"
57,658, // "v"
58,658, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,658, // "c"
60,658, // "i"
61,658, // "l"
62,658, // "o"
63,658, // "u"
64,658, // "b"
65,658, // "n"
66,658, // "t"
69,556, // {193..198 225..230}
71,658, // {"1".."9"}
72,658, // "0"
74,556, // {176..185}
103,433, // $$2
108,478, // hexDigit
109,566, // hexDigit128
  }
,
{ // state 25
7,847, // ID
15,455, // `(
34,548, // <expr6>
36,832, // <expr5>
39,486, // <expr4>
44,475, // `+
45,427, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 26
2,605, // ws*
22,MIN_REDUCTION+96, // `[
75,742, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+96, // "["
MIN_REDUCTION+96, // (default reduction)
  }
,
{ // state 27
7,846, // ID
15,457, // `(
34,552, // <expr6>
36,824, // <expr5>
39,489, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 28
66,130, // "t"
  }
,
{ // state 29
2,754, // ws*
  }
,
{ // state 30
23,465, // `]
92,70, // "]"
  }
,
{ // state 31
2,5, // ws*
75,569, // ws
76,349, // " "
77,13, // {10}
MIN_REDUCTION+96, // (default reduction)
  }
,
{ // state 32
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 33
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 34
38,614, // `<
40,388, // `>
41,80, // `<=
42,346, // `>=
43,114, // `instanceof
78,83, // "#"
79,162, // "@"
94,815, // "<"
95,314, // ">"
MIN_REDUCTION+25, // (default reduction)
  }
,
{ // state 35
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 36
33,188, // `&&
79,485, // "@"
MIN_REDUCTION+22, // (default reduction)
  }
,
{ // state 37
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 38
75,780, // ws
76,618, // " "
77,821, // {10}
MIN_REDUCTION+107, // (default reduction)
  }
,
{ // state 39
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 40
MIN_REDUCTION+51, // (default reduction)
  }
,
{ // state 41
22,MIN_REDUCTION+114, // `[
91,MIN_REDUCTION+114, // "["
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 42
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 43
47,396, // `*
49,196, // `/
50,273, // `%
81,257, // "%"
83,266, // "*"
97,787, // "/"
MIN_REDUCTION+36, // (default reduction)
  }
,
{ // state 44
22,MIN_REDUCTION+114, // `[
91,MIN_REDUCTION+114, // "["
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 45
56,658, // "p"
57,658, // "v"
58,658, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,658, // "c"
60,658, // "i"
61,658, // "l"
62,658, // "o"
63,658, // "u"
64,658, // "b"
65,658, // "n"
66,658, // "t"
69,572, // {193..198 225..230}
71,658, // {"1".."9"}
72,658, // "0"
74,572, // {176..185}
103,420, // $$2
108,478, // hexDigit
109,540, // hexDigit128
  }
,
{ // state 46
22,MIN_REDUCTION+55, // `[
91,MIN_REDUCTION+55, // "["
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 47
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 48
35,480, // `==
37,436, // `!=
79,389, // "@"
MIN_REDUCTION+24, // (default reduction)
  }
,
{ // state 49
2,792, // ws*
  }
,
{ // state 50
2,784, // ws*
  }
,
{ // state 51
56,658, // "p"
57,658, // "v"
58,658, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,658, // "c"
60,658, // "i"
61,658, // "l"
62,658, // "o"
63,658, // "u"
64,658, // "b"
65,658, // "n"
66,658, // "t"
69,574, // {193..198 225..230}
71,658, // {"1".."9"}
72,658, // "0"
74,574, // {176..185}
103,421, // $$2
108,478, // hexDigit
109,538, // hexDigit128
  }
,
{ // state 52
75,525, // ws
76,204, // " "
77,370, // {10}
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 53
7,807, // ID
15,437, // `(
39,409, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 54
33,25, // `&&
79,485, // "@"
MIN_REDUCTION+22, // (default reduction)
  }
,
{ // state 55
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 56
22,MIN_REDUCTION+50, // `[
91,MIN_REDUCTION+50, // "["
MIN_REDUCTION+50, // (default reduction)
  }
,
{ // state 57
7,847, // ID
15,455, // `(
32,318, // <expr7>
34,58, // <expr6>
36,832, // <expr5>
39,486, // <expr4>
44,475, // `+
45,427, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 58
35,459, // `==
37,445, // `!=
79,389, // "@"
MIN_REDUCTION+24, // (default reduction)
  }
,
{ // state 59
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 60
22,MIN_REDUCTION+50, // `[
91,MIN_REDUCTION+50, // "["
MIN_REDUCTION+50, // (default reduction)
  }
,
{ // state 61
7,846, // ID
15,457, // `(
32,320, // <expr7>
34,67, // <expr6>
36,824, // <expr5>
39,489, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 62
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 63
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,706, // letter128
68,579, // {199..218 231..250}
69,579, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,704, // digit128
74,383, // {176..185}
99,234, // $$0
104,797, // idChar
105,767, // "_"
106,335, // idChar128
107,144, // {223}
  }
,
{ // state 64
38,602, // `<
40,247, // `>
41,53, // `<=
42,365, // `>=
43,6, // `instanceof
78,83, // "#"
79,162, // "@"
94,815, // "<"
95,314, // ">"
MIN_REDUCTION+27, // (default reduction)
  }
,
{ // state 65
75,643, // ws
76,731, // " "
77,646, // {10}
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 66
2,584, // ws*
22,MIN_REDUCTION+96, // `[
75,843, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+96, // "["
MIN_REDUCTION+96, // (default reduction)
  }
,
{ // state 67
35,461, // `==
37,443, // `!=
79,389, // "@"
MIN_REDUCTION+24, // (default reduction)
  }
,
{ // state 68
22,MIN_REDUCTION+125, // `[
91,MIN_REDUCTION+125, // "["
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 69
22,MIN_REDUCTION+114, // `[
91,MIN_REDUCTION+114, // "["
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 70
2,211, // ws*
75,142, // ws
76,464, // " "
77,176, // {10}
MIN_REDUCTION+96, // (default reduction)
  }
,
{ // state 71
7,847, // ID
15,455, // `(
28,536, // <expr>
30,656, // <expr8>
32,54, // <expr7>
34,58, // <expr6>
36,832, // <expr5>
39,486, // <expr4>
44,475, // `+
45,427, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 72
33,27, // `&&
79,485, // "@"
MIN_REDUCTION+22, // (default reduction)
  }
,
{ // state 73
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 74
75,87, // ws
76,723, // " "
77,513, // {10}
MIN_REDUCTION+83, // (default reduction)
  }
,
{ // state 75
7,846, // ID
15,457, // `(
39,447, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 76
22,MIN_REDUCTION+111, // `[
75,850, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+111, // "["
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 77
22,MIN_REDUCTION+50, // `[
91,MIN_REDUCTION+50, // "["
MIN_REDUCTION+50, // (default reduction)
  }
,
{ // state 78
7,807, // ID
15,437, // `(
32,344, // <expr7>
34,48, // <expr6>
36,64, // <expr5>
39,542, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 79
63,482, // "u"
  }
,
{ // state 80
7,847, // ID
15,455, // `(
39,446, // <expr4>
44,475, // `+
45,427, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 81
22,MIN_REDUCTION+111, // `[
75,851, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+111, // "["
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 82
75,311, // ws
76,440, // " "
77,510, // {10}
MIN_REDUCTION+97, // (default reduction)
  }
,
{ // state 83
60,739, // "i"
  }
,
{ // state 84
22,MIN_REDUCTION+125, // `[
91,MIN_REDUCTION+125, // "["
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 85
7,352, // ID
8,713, // `{
10,753, // `}
15,457, // `(
17,197, // <stmt>*
18,829, // <type>
19,416, // `int
20,483, // `boolean
24,686, // <stmt>
25,585, // <assign>
27,248, // <local var decl>
28,238, // <expr>
30,661, // <expr8>
32,72, // <expr7>
34,67, // <expr6>
36,824, // <expr5>
39,489, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,588, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,834, // letter128
68,501, // {199..218 231..250}
69,501, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
78,329, // "#"
84,622, // "("
86,297, // "{"
87,206, // "}"
88,123, // "-"
89,20, // "+"
  }
,
{ // state 86
22,MIN_REDUCTION+125, // `[
91,MIN_REDUCTION+125, // "["
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 87
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 88
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 89
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 90
23,95, // `]
92,31, // "]"
  }
,
{ // state 91
2,703, // ws*
75,581, // ws
76,580, // " "
77,769, // {10}
MIN_REDUCTION+86, // (default reduction)
  }
,
{ // state 92
0x80000000|220, // match move
0x80000000|140, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 93
75,202, // ws
76,367, // " "
77,32, // {10}
MIN_REDUCTION+95, // (default reduction)
  }
,
{ // state 94
0x80000000|322, // match move
0x80000000|252, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 95
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 96
22,MIN_REDUCTION+54, // `[
91,MIN_REDUCTION+54, // "["
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 97
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 98
2,502, // ws*
22,MIN_REDUCTION+146, // `[
75,843, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+146, // "["
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 99
0x80000000|174, // match move
0x80000000|793, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 100
23,115, // `]
92,379, // "]"
  }
,
{ // state 101
22,MIN_REDUCTION+111, // `[
75,833, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+111, // "["
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 102
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 103
22,MIN_REDUCTION+56, // `[
91,MIN_REDUCTION+56, // "["
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 104
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 105
0x80000000|220, // match move
0x80000000|128, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 106
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,692, // letter128
68,591, // {199..218 231..250}
69,591, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,150, // digit128
74,432, // {176..185}
99,245, // $$0
104,797, // idChar
105,767, // "_"
106,305, // idChar128
107,136, // {223}
  }
,
{ // state 107
0x80000000|220, // match move
0x80000000|125, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 108
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,690, // letter128
68,590, // {199..218 231..250}
69,590, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,152, // digit128
74,435, // {176..185}
99,246, // $$0
104,797, // idChar
105,767, // "_"
106,310, // idChar128
107,137, // {223}
  }
,
{ // state 109
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 110
23,116, // `]
92,377, // "]"
  }
,
{ // state 111
38,614, // `<
40,388, // `>
41,80, // `<=
42,346, // `>=
43,114, // `instanceof
78,83, // "#"
79,162, // "@"
94,815, // "<"
95,314, // ">"
MIN_REDUCTION+26, // (default reduction)
  }
,
{ // state 112
7,124, // ID
18,308, // <type>
19,307, // `int
20,265, // `boolean
55,256, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,289, // letter128
68,591, // {199..218 231..250}
69,591, // {193..198 225..230}
78,390, // "#"
  }
,
{ // state 113
2,65, // ws*
75,802, // ws
76,731, // " "
77,646, // {10}
MIN_REDUCTION+58, // (default reduction)
  }
,
{ // state 114
7,127, // ID
18,301, // <type>
19,309, // `int
20,261, // `boolean
55,260, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,292, // letter128
68,590, // {199..218 231..250}
69,590, // {193..198 225..230}
78,387, // "#"
  }
,
{ // state 115
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 116
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 117
2,38, // ws*
75,782, // ws
76,618, // " "
77,821, // {10}
MIN_REDUCTION+108, // (default reduction)
  }
,
{ // state 118
75,205, // ws
76,362, // " "
77,35, // {10}
MIN_REDUCTION+95, // (default reduction)
  }
,
{ // state 119
38,615, // `<
40,385, // `>
41,75, // `<=
42,348, // `>=
43,112, // `instanceof
78,83, // "#"
79,162, // "@"
94,815, // "<"
95,314, // ">"
MIN_REDUCTION+26, // (default reduction)
  }
,
{ // state 120
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 121
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 122
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 123
2,840, // ws*
75,647, // ws
76,39, // " "
77,109, // {10}
MIN_REDUCTION+86, // (default reduction)
  }
,
{ // state 124
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 125
22,MIN_REDUCTION+52, // `[
91,MIN_REDUCTION+52, // "["
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 126
75,189, // ws
76,349, // " "
77,13, // {10}
MIN_REDUCTION+63, // (default reduction)
  }
,
{ // state 127
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 128
22,MIN_REDUCTION+52, // `[
91,MIN_REDUCTION+52, // "["
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 129
7,807, // ID
44,454, // `+
46,129, // `-
52,694, // <expr1>
53,462, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
88,123, // "-"
89,20, // "+"
  }
,
{ // state 130
2,160, // ws*
75,802, // ws
76,731, // " "
77,646, // {10}
MIN_REDUCTION+64, // (default reduction)
  }
,
{ // state 131
44,494, // `+
46,522, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+28, // (default reduction)
  }
,
{ // state 132
59,339, // "c"
  }
,
{ // state 133
0x80000000|1, // match move
0x80000000|458, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 134
0x80000000|1, // match move
0x80000000|456, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 135
7,807, // ID
15,437, // `(
28,711, // <expr>
30,687, // <expr8>
32,36, // <expr7>
34,48, // <expr6>
36,64, // <expr5>
39,542, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 136
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 137
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 138
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,660, // letter128
68,625, // {199..218 231..250}
69,625, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,762, // digit128
74,583, // {176..185}
98,169, // idChar*
99,596, // $$0
104,165, // idChar
105,767, // "_"
106,294, // idChar128
107,526, // {223}
  }
,
{ // state 139
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 140
22,MIN_REDUCTION+52, // `[
91,MIN_REDUCTION+52, // "["
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 141
7,846, // ID
44,473, // `+
46,141, // `-
52,664, // <expr1>
53,500, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
88,123, // "-"
89,20, // "+"
  }
,
{ // state 142
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 143
0x80000000|284, // match move
0x80000000|103, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 144
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 145
7,847, // ID
44,475, // `+
46,145, // `-
52,665, // <expr1>
53,498, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
88,123, // "-"
89,20, // "+"
  }
,
{ // state 146
MIN_REDUCTION+6, // (default reduction)
  }
,
{ // state 147
15,477, // `(
84,258, // "("
  }
,
{ // state 148
MIN_REDUCTION+140, // (default reduction)
  }
,
{ // state 149
MIN_REDUCTION+38, // (default reduction)
  }
,
{ // state 150
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 151
MIN_REDUCTION+38, // (default reduction)
  }
,
{ // state 152
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 153
0x80000000|1, // match move
0x80000000|44, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 154
0x80000000|1, // match move
0x80000000|41, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 155
75,89, // ws
76,609, // " "
77,484, // {10}
MIN_REDUCTION+91, // (default reduction)
  }
,
{ // state 156
75,97, // ws
76,628, // " "
77,781, // {10}
MIN_REDUCTION+105, // (default reduction)
  }
,
{ // state 157
MIN_REDUCTION+17, // (default reduction)
  }
,
{ // state 158
MIN_REDUCTION+14, // (default reduction)
  }
,
{ // state 159
44,493, // `+
46,523, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+28, // (default reduction)
  }
,
{ // state 160
75,643, // ws
76,731, // " "
77,646, // {10}
MIN_REDUCTION+63, // (default reduction)
  }
,
{ // state 161
0x80000000|29, // match move
0x80000000|444, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 162
80,671, // "!"
82,589, // "&"
90,535, // "="
93,397, // "|"
94,12, // "<"
95,845, // ">"
  }
,
{ // state 163
0x80000000|1, // match move
0x80000000|476, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 164
0x80000000|1, // match move
0x80000000|463, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 165
MIN_REDUCTION+138, // (default reduction)
  }
,
{ // state 166
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 167
62,113, // "o"
  }
,
{ // state 168
MIN_REDUCTION+53, // (default reduction)
  }
,
{ // state 169
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,660, // letter128
68,625, // {199..218 231..250}
69,625, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,762, // digit128
74,583, // {176..185}
99,405, // $$0
104,797, // idChar
105,767, // "_"
106,294, // idChar128
107,526, // {223}
  }
,
{ // state 170
2,669, // ws*
75,581, // ws
76,580, // " "
77,769, // {10}
MIN_REDUCTION+88, // (default reduction)
  }
,
{ // state 171
0x80000000|1, // match move
0x80000000|474, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 172
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 173
7,MIN_REDUCTION+11, // ID
22,MIN_REDUCTION+48, // `[
56,MIN_REDUCTION+11, // "p"
57,MIN_REDUCTION+11, // "v"
58,MIN_REDUCTION+11, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,MIN_REDUCTION+11, // "c"
60,MIN_REDUCTION+11, // "i"
61,MIN_REDUCTION+11, // "l"
62,MIN_REDUCTION+11, // "o"
63,MIN_REDUCTION+11, // "u"
64,MIN_REDUCTION+11, // "b"
65,MIN_REDUCTION+11, // "n"
66,MIN_REDUCTION+11, // "t"
68,MIN_REDUCTION+11, // {199..218 231..250}
69,MIN_REDUCTION+11, // {193..198 225..230}
91,MIN_REDUCTION+48, // "["
MIN_REDUCTION+48, // (default reduction)
  }
,
{ // state 174
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 175
0x80000000|620, // match move
0x80000000|631, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 176
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 177
7,847, // ID
15,455, // `(
44,475, // `+
46,145, // `-
48,151, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 178
0x80000000|1, // match move
0x80000000|481, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 179
0x80000000|1, // match move
0x80000000|56, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 180
0x80000000|620, // match move
0x80000000|634, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 181
7,846, // ID
15,457, // `(
44,473, // `+
46,141, // `-
48,149, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 182
0x80000000|1, // match move
0x80000000|60, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 183
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 184
47,375, // `*
49,177, // `/
50,359, // `%
81,257, // "%"
83,266, // "*"
97,787, // "/"
MIN_REDUCTION+34, // (default reduction)
  }
,
{ // state 185
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 186
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 187
MIN_REDUCTION+122, // (default reduction)
  }
,
{ // state 188
7,807, // ID
15,437, // `(
34,619, // <expr6>
36,64, // <expr5>
39,542, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 189
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 190
22,MIN_REDUCTION+117, // `[
75,851, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+117, // "["
MIN_REDUCTION+117, // (default reduction)
  }
,
{ // state 191
22,MIN_REDUCTION+117, // `[
75,850, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+117, // "["
MIN_REDUCTION+117, // (default reduction)
  }
,
{ // state 192
0x80000000|1, // match move
0x80000000|3, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 193
47,376, // `*
49,181, // `/
50,368, // `%
81,257, // "%"
83,266, // "*"
97,787, // "/"
MIN_REDUCTION+34, // (default reduction)
  }
,
{ // state 194
0x80000000|1, // match move
0x80000000|77, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 195
0x80000000|620, // match move
0x80000000|674, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 196
7,807, // ID
15,437, // `(
44,454, // `+
46,129, // `-
48,279, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 197
7,352, // ID
8,713, // `{
10,451, // `}
15,457, // `(
18,829, // <type>
19,416, // `int
20,483, // `boolean
24,509, // <stmt>
25,585, // <assign>
27,248, // <local var decl>
28,238, // <expr>
30,661, // <expr8>
32,72, // <expr7>
34,67, // <expr6>
36,824, // <expr5>
39,489, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,588, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,834, // letter128
68,501, // {199..218 231..250}
69,501, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
78,329, // "#"
84,622, // "("
86,297, // "{"
87,206, // "}"
88,123, // "-"
89,20, // "+"
  }
,
{ // state 198
2,577, // ws*
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 199
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 200
75,73, // ws
76,593, // " "
77,756, // {10}
MIN_REDUCTION+109, // (default reduction)
  }
,
{ // state 201
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 202
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 203
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 204
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 205
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 206
2,496, // ws*
75,201, // ws
76,790, // " "
77,594, // {10}
MIN_REDUCTION+84, // (default reduction)
  }
,
{ // state 207
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 208
7,807, // ID
15,437, // `(
28,726, // <expr>
30,687, // <expr8>
32,36, // <expr7>
34,48, // <expr6>
36,64, // <expr5>
39,542, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 209
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 210
0x80000000|1, // match move
0x80000000|541, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 211
75,624, // ws
76,464, // " "
77,176, // {10}
MIN_REDUCTION+95, // (default reduction)
  }
,
{ // state 212
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 213
22,MIN_REDUCTION+117, // `[
75,833, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+117, // "["
MIN_REDUCTION+117, // (default reduction)
  }
,
{ // state 214
0x80000000|1, // match move
0x80000000|539, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 215
7,807, // ID
15,437, // `(
28,696, // <expr>
30,687, // <expr8>
32,36, // <expr7>
34,48, // <expr6>
36,64, // <expr5>
39,542, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 216
MIN_REDUCTION+132, // (default reduction)
  }
,
{ // state 217
62,338, // "o"
  }
,
{ // state 218
75,353, // ws
76,236, // " "
77,650, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 219
22,MIN_REDUCTION+141, // `[
91,MIN_REDUCTION+141, // "["
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 220
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 221
2,584, // ws*
  }
,
{ // state 222
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 223
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 224
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 225
75,780, // ws
76,618, // " "
77,821, // {10}
MIN_REDUCTION+83, // (default reduction)
  }
,
{ // state 226
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 227
70,372, // digit
71,678, // {"1".."9"}
72,678, // "0"
73,546, // digit128
74,567, // {176..185}
100,324, // digit*
101,164, // $$1
  }
,
{ // state 228
47,376, // `*
49,181, // `/
50,368, // `%
81,257, // "%"
83,266, // "*"
97,787, // "/"
MIN_REDUCTION+35, // (default reduction)
  }
,
{ // state 229
MIN_REDUCTION+131, // (default reduction)
  }
,
{ // state 230
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,33, // letter128
68,681, // {199..218 231..250}
69,681, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,848, // digit128
74,183, // {176..185}
99,172, // $$0
104,797, // idChar
105,767, // "_"
106,303, // idChar128
107,223, // {223}
  }
,
{ // state 231
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 232
22,215, // `[
91,340, // "["
MIN_REDUCTION+47, // (default reduction)
  }
,
{ // state 233
22,208, // `[
91,340, // "["
MIN_REDUCTION+47, // (default reduction)
  }
,
{ // state 234
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 235
2,605, // ws*
  }
,
{ // state 236
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 237
2,603, // ws*
  }
,
{ // state 238
29,528, // `=
90,504, // "="
  }
,
{ // state 239
0x80000000|235, // match move
0x80000000|26, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 240
0x80000000|237, // match move
0x80000000|23, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 241
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,706, // letter128
68,579, // {199..218 231..250}
69,579, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,704, // digit128
74,383, // {176..185}
98,63, // idChar*
99,104, // $$0
104,165, // idChar
105,767, // "_"
106,335, // idChar128
107,144, // {223}
  }
,
{ // state 242
75,316, // ws
76,224, // " "
77,651, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 243
0x80000000|357, // match move
0x80000000|608, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 244
0x80000000|356, // match move
0x80000000|611, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 245
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 246
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 247
7,807, // ID
15,437, // `(
39,698, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 248
26,157, // `;
96,117, // ";"
  }
,
{ // state 249
2,126, // ws*
75,569, // ws
76,349, // " "
77,13, // {10}
MIN_REDUCTION+64, // (default reduction)
  }
,
{ // state 250
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 251
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 252
22,MIN_REDUCTION+142, // `[
91,MIN_REDUCTION+142, // "["
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 253
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 254
2,218, // ws*
75,209, // ws
76,236, // " "
77,650, // {10}
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 255
5,148, // <class decl>
6,676, // `class
78,132, // "#"
MIN_REDUCTION+3, // (default reduction)
  }
,
{ // state 256
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,692, // letter128
68,591, // {199..218 231..250}
69,591, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,150, // digit128
74,432, // {176..185}
98,106, // idChar*
99,62, // $$0
104,165, // idChar
105,767, // "_"
106,305, // idChar128
107,136, // {223}
  }
,
{ // state 257
2,490, // ws*
75,563, // ws
76,593, // " "
77,756, // {10}
MIN_REDUCTION+72, // (default reduction)
  }
,
{ // state 258
2,722, // ws*
75,8, // ws
76,222, // " "
77,652, // {10}
MIN_REDUCTION+78, // (default reduction)
  }
,
{ // state 259
0x80000000|341, // match move
0x80000000|533, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 260
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,690, // letter128
68,590, // {199..218 231..250}
69,590, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,152, // digit128
74,435, // {176..185}
98,108, // idChar*
99,59, // $$0
104,165, // idChar
105,767, // "_"
106,310, // idChar128
107,137, // {223}
  }
,
{ // state 261
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 262
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,33, // letter128
68,681, // {199..218 231..250}
69,681, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,848, // digit128
74,183, // {176..185}
98,230, // idChar*
99,487, // $$0
104,165, // idChar
105,767, // "_"
106,303, // idChar128
107,223, // {223}
  }
,
{ // state 263
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 264
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 265
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 266
2,783, // ws*
75,563, // ws
76,593, // " "
77,756, // {10}
MIN_REDUCTION+76, // (default reduction)
  }
,
{ // state 267
0x80000000|1, // match move
0x80000000|682, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 268
0x80000000|1, // match move
0x80000000|685, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 269
0x80000000|280, // match move
0x80000000|709, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 270
2,595, // ws*
75,569, // ws
76,349, // " "
77,13, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 271
75,350, // ws
76,263, // " "
77,724, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 272
47,396, // `*
49,196, // `/
50,273, // `%
81,257, // "%"
83,266, // "*"
97,787, // "/"
MIN_REDUCTION+35, // (default reduction)
  }
,
{ // state 273
7,807, // ID
15,437, // `(
44,454, // `+
46,129, // `-
48,511, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 274
0x80000000|1, // match move
0x80000000|697, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 275
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 276
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 277
0x80000000|49, // match move
0x80000000|837, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 278
2,424, // ws*
75,592, // ws
76,628, // " "
77,781, // {10}
MIN_REDUCTION+104, // (default reduction)
  }
,
{ // state 279
MIN_REDUCTION+38, // (default reduction)
  }
,
{ // state 280
2,381, // ws*
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 281
75,212, // ws
76,718, // " "
77,791, // {10}
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 282
66,402, // "t"
  }
,
{ // state 283
0x80000000|50, // match move
0x80000000|836, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 284
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 285
21,814, // <empty bracket pair>
22,90, // `[
91,712, // "["
MIN_REDUCTION+32, // (default reduction)
  }
,
{ // state 286
MIN_REDUCTION+40, // (default reduction)
  }
,
{ // state 287
111,MIN_REDUCTION+141, // $NT
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 288
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 289
2,564, // ws*
75,555, // ws
76,367, // " "
77,32, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 290
MIN_REDUCTION+2, // (default reduction)
  }
,
{ // state 291
75,205, // ws
76,362, // " "
77,35, // {10}
MIN_REDUCTION+63, // (default reduction)
  }
,
{ // state 292
2,571, // ws*
75,551, // ws
76,362, // " "
77,35, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 293
75,202, // ws
76,367, // " "
77,32, // {10}
MIN_REDUCTION+63, // (default reduction)
  }
,
{ // state 294
2,570, // ws*
75,802, // ws
76,731, // " "
77,646, // {10}
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 295
MIN_REDUCTION+40, // (default reduction)
  }
,
{ // state 296
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,4, // letter128
68,648, // {199..218 231..250}
69,648, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,823, // digit128
74,207, // {176..185}
99,19, // $$0
104,797, // idChar
105,767, // "_"
106,254, // idChar128
107,251, // {223}
  }
,
{ // state 297
2,748, // ws*
75,121, // ws
76,448, // " "
77,47, // {10}
MIN_REDUCTION+82, // (default reduction)
  }
,
{ // state 298
0x80000000|1, // match move
0x80000000|439, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 299
MIN_REDUCTION+40, // (default reduction)
  }
,
{ // state 300
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 301
21,800, // <empty bracket pair>
22,110, // `[
91,712, // "["
MIN_REDUCTION+32, // (default reduction)
  }
,
{ // state 302
0x80000000|221, // match move
0x80000000|66, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 303
2,271, // ws*
75,186, // ws
76,263, // " "
77,724, // {10}
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 304
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,102, // letter128
68,635, // {199..218 231..250}
69,635, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,817, // digit128
74,231, // {176..185}
99,42, // $$0
104,797, // idChar
105,767, // "_"
106,392, // idChar128
107,264, // {223}
  }
,
{ // state 305
2,779, // ws*
75,555, // ws
76,367, // " "
77,32, // {10}
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 306
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 307
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 308
21,799, // <empty bracket pair>
22,100, // `[
91,712, // "["
MIN_REDUCTION+32, // (default reduction)
  }
,
{ // state 309
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 310
2,795, // ws*
75,551, // ws
76,362, // " "
77,35, // {10}
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 311
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 312
0x80000000|1, // match move
0x80000000|101, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 313
2,667, // ws*
75,22, // ws
76,600, // " "
77,801, // {10}
111,MIN_REDUCTION+96, // $NT
  }
,
{ // state 314
0x80000000|1, // match move
0x80000000|278, // no-match move
// T-test match for "=":
90,
  }
,
{ // state 315
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 316
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 317
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 318
33,25, // `&&
79,485, // "@"
MIN_REDUCTION+21, // (default reduction)
  }
,
{ // state 319
22,MIN_REDUCTION+49, // `[
91,MIN_REDUCTION+49, // "["
MIN_REDUCTION+49, // (default reduction)
  }
,
{ // state 320
33,27, // `&&
79,485, // "@"
MIN_REDUCTION+21, // (default reduction)
  }
,
{ // state 321
2,545, // ws*
75,186, // ws
76,263, // " "
77,724, // {10}
MIN_REDUCTION+80, // (default reduction)
  }
,
{ // state 322
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 323
MIN_REDUCTION+46, // (default reduction)
  }
,
{ // state 324
70,649, // digit
71,678, // {"1".."9"}
72,678, // "0"
73,546, // digit128
74,567, // {176..185}
101,554, // $$1
  }
,
{ // state 325
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 326
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 327
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 328
60,759, // "i"
64,735, // "b"
  }
,
{ // state 329
60,282, // "i"
64,217, // "b"
  }
,
{ // state 330
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 331
0x80000000|757, // match move
0x80000000|516, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 332
0x80000000|55, // match move
0x80000000|46, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 333
2,707, // ws*
75,802, // ws
76,731, // " "
77,646, // {10}
MIN_REDUCTION+96, // (default reduction)
  }
,
{ // state 334
70,649, // digit
71,678, // {"1".."9"}
72,678, // "0"
73,617, // digit128
74,527, // {176..185}
101,565, // $$1
  }
,
{ // state 335
2,700, // ws*
75,569, // ws
76,349, // " "
77,13, // {10}
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 336
70,649, // digit
71,678, // {"1".."9"}
72,678, // "0"
73,623, // digit128
74,529, // {176..185}
101,568, // $$1
  }
,
{ // state 337
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 338
2,414, // ws*
75,142, // ws
76,464, // " "
77,176, // {10}
MIN_REDUCTION+58, // (default reduction)
  }
,
{ // state 339
61,9, // "l"
  }
,
{ // state 340
2,725, // ws*
75,668, // ws
76,88, // " "
77,14, // {10}
MIN_REDUCTION+94, // (default reduction)
  }
,
{ // state 341
2,798, // ws*
  }
,
{ // state 342
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 343
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 344
33,188, // `&&
79,485, // "@"
MIN_REDUCTION+21, // (default reduction)
  }
,
{ // state 345
22,MIN_REDUCTION+115, // `[
91,MIN_REDUCTION+115, // "["
MIN_REDUCTION+115, // (default reduction)
  }
,
{ // state 346
7,847, // ID
15,455, // `(
39,765, // <expr4>
44,475, // `+
45,427, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 347
22,MIN_REDUCTION+115, // `[
91,MIN_REDUCTION+115, // "["
MIN_REDUCTION+115, // (default reduction)
  }
,
{ // state 348
7,846, // ID
15,457, // `(
39,770, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 349
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 350
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 351
22,MIN_REDUCTION+143, // `[
75,701, // ws
76,332, // " "
77,143, // {10}
91,MIN_REDUCTION+143, // "["
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 352
0x80000000|122, // match move
0x80000000|173, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 353
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 354
75,412, // ws
76,449, // " "
77,429, // {10}
MIN_REDUCTION+79, // (default reduction)
  }
,
{ // state 355
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 356
2,828, // ws*
  }
,
{ // state 357
2,825, // ws*
  }
,
{ // state 358
22,MIN_REDUCTION+49, // `[
91,MIN_REDUCTION+49, // "["
MIN_REDUCTION+49, // (default reduction)
  }
,
{ // state 359
7,847, // ID
15,455, // `(
44,475, // `+
46,145, // `-
48,521, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 360
0x80000000|1, // match move
0x80000000|732, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 361
22,MIN_REDUCTION+49, // `[
91,MIN_REDUCTION+49, // "["
MIN_REDUCTION+49, // (default reduction)
  }
,
{ // state 362
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 363
0x80000000|1, // match move
0x80000000|730, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 364
22,MIN_REDUCTION+115, // `[
91,MIN_REDUCTION+115, // "["
MIN_REDUCTION+115, // (default reduction)
  }
,
{ // state 365
7,807, // ID
15,437, // `(
39,839, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 366
110,MIN_REDUCTION+0, // $
  }
,
{ // state 367
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 368
7,846, // ID
15,457, // `(
44,473, // `+
46,141, // `-
48,519, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 369
2,293, // ws*
75,555, // ws
76,367, // " "
77,32, // {10}
MIN_REDUCTION+64, // (default reduction)
  }
,
{ // state 370
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 371
2,291, // ws*
75,551, // ws
76,362, // " "
77,35, // {10}
MIN_REDUCTION+64, // (default reduction)
  }
,
{ // state 372
MIN_REDUCTION+130, // (default reduction)
  }
,
{ // state 373
62,468, // "o"
  }
,
{ // state 374
0x80000000|505, // match move
0x80000000|785, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 375
7,847, // ID
15,455, // `(
44,475, // `+
46,145, // `-
48,404, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 376
7,846, // ID
15,457, // `(
44,473, // `+
46,141, // `-
48,403, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 377
2,118, // ws*
75,551, // ws
76,362, // " "
77,35, // {10}
MIN_REDUCTION+96, // (default reduction)
  }
,
{ // state 378
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,102, // letter128
68,635, // {199..218 231..250}
69,635, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,817, // digit128
74,231, // {176..185}
98,304, // idChar*
99,573, // $$0
104,165, // idChar
105,767, // "_"
106,392, // idChar128
107,264, // {223}
  }
,
{ // state 379
2,93, // ws*
75,555, // ws
76,367, // " "
77,32, // {10}
MIN_REDUCTION+96, // (default reduction)
  }
,
{ // state 380
22,MIN_REDUCTION+141, // `[
91,MIN_REDUCTION+141, // "["
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 381
0x80000000|838, // match move
0x80000000|351, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 382
MIN_REDUCTION+37, // (default reduction)
  }
,
{ // state 383
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 384
22,MIN_REDUCTION+141, // `[
91,MIN_REDUCTION+141, // "["
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 385
7,846, // ID
15,457, // `(
39,684, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 386
2,281, // ws*
75,343, // ws
76,718, // " "
77,791, // {10}
MIN_REDUCTION+66, // (default reduction)
  }
,
{ // state 387
60,844, // "i"
64,777, // "b"
  }
,
{ // state 388
7,847, // ID
15,455, // `(
39,683, // <expr4>
44,475, // `+
45,427, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 389
80,671, // "!"
82,589, // "&"
90,535, // "="
93,397, // "|"
  }
,
{ // state 390
60,841, // "i"
64,764, // "b"
  }
,
{ // state 391
2,719, // ws*
75,551, // ws
76,362, // " "
77,35, // {10}
MIN_REDUCTION+58, // (default reduction)
  }
,
{ // state 392
2,242, // ws*
75,7, // ws
76,224, // " "
77,651, // {10}
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 393
70,372, // digit
71,678, // {"1".."9"}
72,678, // "0"
73,617, // digit128
74,527, // {176..185}
100,334, // digit*
101,171, // $$1
  }
,
{ // state 394
29,71, // `=
90,504, // "="
  }
,
{ // state 395
2,720, // ws*
75,555, // ws
76,367, // " "
77,32, // {10}
MIN_REDUCTION+58, // (default reduction)
  }
,
{ // state 396
7,807, // ID
15,437, // `(
44,454, // `+
46,129, // `-
48,382, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 397
2,82, // ws*
75,633, // ws
76,440, // " "
77,510, // {10}
MIN_REDUCTION+98, // (default reduction)
  }
,
{ // state 398
75,97, // ws
76,628, // " "
77,781, // {10}
MIN_REDUCTION+101, // (default reduction)
  }
,
{ // state 399
0x80000000|226, // match move
0x80000000|820, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 400
10,766, // `}
11,229, // <decl in class>
12,146, // <method decl>
13,796, // `public
78,745, // "#"
87,508, // "}"
  }
,
{ // state 401
22,MIN_REDUCTION+141, // `[
91,MIN_REDUCTION+141, // "["
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 402
2,422, // ws*
75,142, // ws
76,464, // " "
77,176, // {10}
MIN_REDUCTION+64, // (default reduction)
  }
,
{ // state 403
MIN_REDUCTION+37, // (default reduction)
  }
,
{ // state 404
MIN_REDUCTION+37, // (default reduction)
  }
,
{ // state 405
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 406
0x80000000|1, // match move
0x80000000|76, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 407
0x80000000|1, // match move
0x80000000|81, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 408
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 409
44,506, // `+
46,514, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+30, // (default reduction)
  }
,
{ // state 410
0x80000000|557, // match move
0x80000000|758, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 411
70,372, // digit
71,678, // {"1".."9"}
72,678, // "0"
73,623, // digit128
74,529, // {176..185}
100,336, // digit*
101,178, // $$1
  }
,
{ // state 412
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 413
0x80000000|558, // match move
0x80000000|755, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 414
75,624, // ws
76,464, // " "
77,176, // {10}
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 415
22,135, // `[
91,340, // "["
MIN_REDUCTION+47, // (default reduction)
  }
,
{ // state 416
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 417
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 418
22,MIN_REDUCTION+119, // `[
91,MIN_REDUCTION+119, // "["
MIN_REDUCTION+119, // (default reduction)
  }
,
{ // state 419
75,37, // ws
76,794, // " "
77,613, // {10}
MIN_REDUCTION+59, // (default reduction)
  }
,
{ // state 420
0x80000000|1, // match move
0x80000000|15, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 421
0x80000000|1, // match move
0x80000000|16, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 422
75,624, // ws
76,464, // " "
77,176, // {10}
MIN_REDUCTION+63, // (default reduction)
  }
,
{ // state 423
47,376, // `*
49,181, // `/
50,368, // `%
81,257, // "%"
83,266, // "*"
97,787, // "/"
MIN_REDUCTION+36, // (default reduction)
  }
,
{ // state 424
75,97, // ws
76,628, // " "
77,781, // {10}
MIN_REDUCTION+103, // (default reduction)
  }
,
{ // state 425
47,375, // `*
49,177, // `/
50,359, // `%
81,257, // "%"
83,266, // "*"
97,787, // "/"
MIN_REDUCTION+35, // (default reduction)
  }
,
{ // state 426
2,640, // ws*
75,569, // ws
76,349, // " "
77,13, // {10}
MIN_REDUCTION+58, // (default reduction)
  }
,
{ // state 427
47,375, // `*
49,177, // `/
50,359, // `%
81,257, // "%"
83,266, // "*"
97,787, // "/"
MIN_REDUCTION+36, // (default reduction)
  }
,
{ // state 428
MIN_REDUCTION+121, // (default reduction)
  }
,
{ // state 429
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 430
MIN_REDUCTION+46, // (default reduction)
  }
,
{ // state 431
MIN_REDUCTION+46, // (default reduction)
  }
,
{ // state 432
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 433
0x80000000|1, // match move
0x80000000|418, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 434
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,4, // letter128
68,648, // {199..218 231..250}
69,648, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,823, // digit128
74,207, // {176..185}
98,296, // idChar*
99,550, // $$0
104,165, // idChar
105,767, // "_"
106,254, // idChar128
107,251, // {223}
  }
,
{ // state 435
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 436
7,807, // ID
15,437, // `(
36,822, // <expr5>
39,542, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
};
}
private class Initter2{
public int doInit(int startIdx) {
  for (int i = 0; i < myParseTable.length; i++) {
    parseTable[i+startIdx] = myParseTable[i];
  }
  return myParseTable.length;
}
private final int[][] myParseTable = {
{ // state 437
7,645, // ID
18,599, // <type>
19,639, // `int
20,778, // `boolean
55,138, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,438, // letter128
68,625, // {199..218 231..250}
69,625, // {193..198 225..230}
78,680, // "#"
  }
,
{ // state 438
2,663, // ws*
75,802, // ws
76,731, // " "
77,646, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 439
22,135, // `[
91,340, // "["
MIN_REDUCTION+43, // (default reduction)
  }
,
{ // state 440
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 441
22,MIN_REDUCTION+143, // `[
75,833, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+143, // "["
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 442
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 443
7,846, // ID
15,457, // `(
36,119, // <expr5>
39,489, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 444
2,754, // ws*
22,MIN_REDUCTION+144, // `[
75,843, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+144, // "["
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 445
7,847, // ID
15,455, // `(
36,111, // <expr5>
39,486, // <expr4>
44,475, // `+
45,427, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 446
44,494, // `+
46,522, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+30, // (default reduction)
  }
,
{ // state 447
44,493, // `+
46,523, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+30, // (default reduction)
  }
,
{ // state 448
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 449
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 450
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 451
MIN_REDUCTION+7, // (default reduction)
  }
,
{ // state 452
111,MIN_REDUCTION+13, // $NT
  }
,
{ // state 453
0x80000000|699, // match move
0x80000000|96, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 454
7,807, // ID
44,454, // `+
46,129, // `-
52,694, // <expr1>
53,323, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
88,123, // "-"
89,20, // "+"
  }
,
{ // state 455
7,645, // ID
18,627, // <type>
19,639, // `int
20,778, // `boolean
55,138, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,438, // letter128
68,625, // {199..218 231..250}
69,625, // {193..198 225..230}
78,680, // "#"
  }
,
{ // state 456
22,MIN_REDUCTION+120, // `[
91,MIN_REDUCTION+120, // "["
MIN_REDUCTION+120, // (default reduction)
  }
,
{ // state 457
7,645, // ID
18,629, // <type>
19,639, // `int
20,778, // `boolean
55,138, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,438, // letter128
68,625, // {199..218 231..250}
69,625, // {193..198 225..230}
78,680, // "#"
  }
,
{ // state 458
22,MIN_REDUCTION+120, // `[
91,MIN_REDUCTION+120, // "["
MIN_REDUCTION+120, // (default reduction)
  }
,
{ // state 459
7,847, // ID
15,455, // `(
36,34, // <expr5>
39,486, // <expr4>
44,475, // `+
45,427, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 460
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,180, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,763, // digit128
74,529, // {176..185}
99,267, // $$0
104,797, // idChar
105,767, // "_"
106,283, // idChar128
107,688, // {223}
  }
,
{ // state 461
7,846, // ID
15,457, // `(
36,10, // <expr5>
39,489, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 462
MIN_REDUCTION+45, // (default reduction)
  }
,
{ // state 463
22,MIN_REDUCTION+116, // `[
91,MIN_REDUCTION+116, // "["
MIN_REDUCTION+116, // (default reduction)
  }
,
{ // state 464
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 465
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 466
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 467
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,175, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,760, // digit128
74,527, // {176..185}
99,268, // $$0
104,797, // idChar
105,767, // "_"
106,277, // idChar128
107,693, // {223}
  }
,
{ // state 468
2,812, // ws*
75,276, // ws
76,794, // " "
77,613, // {10}
MIN_REDUCTION+62, // (default reduction)
  }
,
{ // state 469
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 470
22,MIN_REDUCTION+143, // `[
75,850, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+143, // "["
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 471
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,819, // letter128
68,501, // {199..218 231..250}
69,501, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,99, // digit128
74,453, // {176..185}
99,331, // $$0
104,797, // idChar
105,767, // "_"
106,269, // idChar128
107,399, // {223}
  }
,
{ // state 472
22,MIN_REDUCTION+143, // `[
75,851, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+143, // "["
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 473
7,846, // ID
44,473, // `+
46,141, // `-
52,664, // <expr1>
53,431, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
88,123, // "-"
89,20, // "+"
  }
,
{ // state 474
22,MIN_REDUCTION+116, // `[
91,MIN_REDUCTION+116, // "["
MIN_REDUCTION+116, // (default reduction)
  }
,
{ // state 475
7,847, // ID
44,475, // `+
46,145, // `-
52,665, // <expr1>
53,430, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
88,123, // "-"
89,20, // "+"
  }
,
{ // state 476
22,MIN_REDUCTION+120, // `[
91,MIN_REDUCTION+120, // "["
MIN_REDUCTION+120, // (default reduction)
  }
,
{ // state 477
16,811, // `)
85,321, // ")"
  }
,
{ // state 478
MIN_REDUCTION+133, // (default reduction)
  }
,
{ // state 479
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,195, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,749, // digit128
74,567, // {176..185}
99,274, // $$0
104,797, // idChar
105,767, // "_"
106,161, // idChar128
107,702, // {223}
  }
,
{ // state 480
7,807, // ID
15,437, // `(
36,786, // <expr5>
39,542, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 481
22,MIN_REDUCTION+116, // `[
91,MIN_REDUCTION+116, // "["
MIN_REDUCTION+116, // (default reduction)
  }
,
{ // state 482
2,52, // ws*
75,166, // ws
76,204, // " "
77,370, // {10}
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 483
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 484
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 485
82,589, // "&"
93,397, // "|"
  }
,
{ // state 486
44,494, // `+
46,522, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+33, // (default reduction)
  }
,
{ // state 487
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 488
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 489
44,493, // `+
46,523, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+33, // (default reduction)
  }
,
{ // state 490
75,73, // ws
76,593, // " "
77,756, // {10}
MIN_REDUCTION+71, // (default reduction)
  }
,
{ // state 491
MIN_REDUCTION+41, // (default reduction)
  }
,
{ // state 492
MIN_REDUCTION+41, // (default reduction)
  }
,
{ // state 493
7,846, // ID
15,457, // `(
44,473, // `+
45,193, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 494
7,847, // ID
15,455, // `(
44,475, // `+
45,184, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 495
MIN_REDUCTION+51, // (default reduction)
  }
,
{ // state 496
75,203, // ws
76,790, // " "
77,594, // {10}
MIN_REDUCTION+83, // (default reduction)
  }
,
{ // state 497
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 498
MIN_REDUCTION+45, // (default reduction)
  }
,
{ // state 499
2,225, // ws*
75,782, // ws
76,618, // " "
77,821, // {10}
MIN_REDUCTION+84, // (default reduction)
  }
,
{ // state 500
MIN_REDUCTION+45, // (default reduction)
  }
,
{ // state 501
0x80000000|642, // match move
0x80000000|705, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 502
0x80000000|1, // match move
0x80000000|710, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 503
MIN_REDUCTION+41, // (default reduction)
  }
,
{ // state 504
2,738, // ws*
75,668, // ws
76,88, // " "
77,14, // {10}
MIN_REDUCTION+90, // (default reduction)
  }
,
{ // state 505
2,312, // ws*
  }
,
{ // state 506
7,807, // ID
15,437, // `(
44,454, // `+
45,655, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 507
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 508
2,74, // ws*
75,466, // ws
76,723, // " "
77,513, // {10}
MIN_REDUCTION+84, // (default reduction)
  }
,
{ // state 509
MIN_REDUCTION+135, // (default reduction)
  }
,
{ // state 510
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 511
MIN_REDUCTION+39, // (default reduction)
  }
,
{ // state 512
22,215, // `[
91,340, // "["
MIN_REDUCTION+43, // (default reduction)
  }
,
{ // state 513
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 514
7,807, // ID
15,437, // `(
44,454, // `+
45,272, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 515
22,208, // `[
91,340, // "["
MIN_REDUCTION+43, // (default reduction)
  }
,
{ // state 516
22,MIN_REDUCTION+113, // `[
91,MIN_REDUCTION+113, // "["
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 517
MIN_REDUCTION+128, // (default reduction)
  }
,
{ // state 518
0x80000000|532, // match move
0x80000000|69, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 519
MIN_REDUCTION+39, // (default reduction)
  }
,
{ // state 520
22,MIN_REDUCTION+124, // `[
91,MIN_REDUCTION+124, // "["
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 521
MIN_REDUCTION+39, // (default reduction)
  }
,
{ // state 522
7,847, // ID
15,455, // `(
44,475, // `+
45,425, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 523
7,846, // ID
15,457, // `(
44,473, // `+
45,228, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 524
MIN_REDUCTION+15, // (default reduction)
  }
,
{ // state 525
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 526
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 527
0x80000000|469, // match move
0x80000000|714, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 528
7,847, // ID
15,455, // `(
28,816, // <expr>
30,656, // <expr8>
32,54, // <expr7>
34,58, // <expr6>
36,832, // <expr5>
39,486, // <expr4>
44,475, // `+
45,427, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 529
0x80000000|469, // match move
0x80000000|715, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 530
8,653, // `{
86,689, // "{"
  }
,
{ // state 531
0x80000000|1, // match move
0x80000000|512, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 532
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 533
2,798, // ws*
22,MIN_REDUCTION+118, // `[
75,843, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+118, // "["
MIN_REDUCTION+118, // (default reduction)
  }
,
{ // state 534
0x80000000|1, // match move
0x80000000|515, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 535
2,155, // ws*
75,601, // ws
76,609, // " "
77,484, // {10}
MIN_REDUCTION+92, // (default reduction)
  }
,
{ // state 536
MIN_REDUCTION+19, // (default reduction)
  }
,
{ // state 537
3,830, // <program>
4,255, // <class decl>+
5,673, // <class decl>
6,676, // `class
75,185, // ws
76,507, // " "
77,442, // {10}
78,132, // "#"
  }
,
{ // state 538
0x80000000|575, // match move
0x80000000|630, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 539
22,MIN_REDUCTION+55, // `[
91,MIN_REDUCTION+55, // "["
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 540
0x80000000|578, // match move
0x80000000|621, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 541
22,MIN_REDUCTION+55, // `[
91,MIN_REDUCTION+55, // "["
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 542
44,506, // `+
46,514, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+33, // (default reduction)
  }
,
{ // state 543
2,363, // ws*
  }
,
{ // state 544
2,586, // ws*
22,MIN_REDUCTION+148, // `[
75,843, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+148, // "["
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 545
75,350, // ws
76,263, // " "
77,724, // {10}
MIN_REDUCTION+79, // (default reduction)
  }
,
{ // state 546
0x80000000|728, // match move
0x80000000|98, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 547
22,MIN_REDUCTION+48, // `[
91,MIN_REDUCTION+48, // "["
MIN_REDUCTION+48, // (default reduction)
  }
,
{ // state 548
35,459, // `==
37,445, // `!=
79,389, // "@"
MIN_REDUCTION+23, // (default reduction)
  }
,
{ // state 549
22,MIN_REDUCTION+48, // `[
91,MIN_REDUCTION+48, // "["
MIN_REDUCTION+48, // (default reduction)
  }
,
{ // state 550
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 551
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 552
35,461, // `==
37,443, // `!=
79,389, // "@"
MIN_REDUCTION+23, // (default reduction)
  }
,
{ // state 553
57,373, // "v"
  }
,
{ // state 554
0x80000000|1, // match move
0x80000000|364, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 555
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 556
0x80000000|517, // match move
0x80000000|721, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 557
2,406, // ws*
  }
,
{ // state 558
2,407, // ws*
  }
,
{ // state 559
75,212, // ws
76,718, // " "
77,791, // {10}
MIN_REDUCTION+77, // (default reduction)
  }
,
{ // state 560
2,586, // ws*
  }
,
{ // state 561
22,MIN_REDUCTION+48, // `[
91,MIN_REDUCTION+48, // "["
MIN_REDUCTION+48, // (default reduction)
  }
,
{ // state 562
75,97, // ws
76,628, // " "
77,781, // {10}
MIN_REDUCTION+99, // (default reduction)
  }
,
{ // state 563
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 564
75,202, // ws
76,367, // " "
77,32, // {10}
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 565
0x80000000|1, // match move
0x80000000|345, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 566
0x80000000|560, // match move
0x80000000|544, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 567
0x80000000|469, // match move
0x80000000|727, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 568
0x80000000|1, // match move
0x80000000|347, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 569
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 570
75,643, // ws
76,731, // " "
77,646, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 571
75,205, // ws
76,362, // " "
77,35, // {10}
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 572
0x80000000|517, // match move
0x80000000|734, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 573
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 574
0x80000000|517, // match move
0x80000000|733, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 575
2,606, // ws*
  }
,
{ // state 576
75,353, // ws
76,236, // " "
77,650, // {10}
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 577
0x80000000|306, // match move
0x80000000|598, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 578
2,607, // ws*
  }
,
{ // state 579
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 580
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 581
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 582
75,316, // ws
76,224, // " "
77,651, // {10}
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 583
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 584
0x80000000|1, // match move
0x80000000|716, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 585
26,158, // `;
96,117, // ";"
  }
,
{ // state 586
0x80000000|1, // match move
0x80000000|809, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 587
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 588
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,819, // letter128
68,501, // {199..218 231..250}
69,501, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,99, // digit128
74,453, // {176..185}
98,471, // idChar*
99,518, // $$0
104,165, // idChar
105,767, // "_"
106,269, // idChar128
107,399, // {223}
  }
,
{ // state 589
2,11, // ws*
75,612, // ws
76,450, // " "
77,497, // {10}
MIN_REDUCTION+74, // (default reduction)
  }
,
{ // state 590
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 591
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 592
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 593
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 594
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 595
75,189, // ws
76,349, // " "
77,13, // {10}
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 596
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 597
75,337, // ws
76,250, // " "
77,636, // {10}
MIN_REDUCTION+93, // (default reduction)
  }
,
{ // state 598
22,MIN_REDUCTION+111, // `[
75,701, // ws
76,332, // " "
77,143, // {10}
91,MIN_REDUCTION+111, // "["
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 599
16,804, // `)
21,18, // <empty bracket pair>
22,849, // `[
85,641, // ")"
91,712, // "["
  }
,
{ // state 600
111,MIN_REDUCTION+55, // $NT
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 601
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 602
7,807, // ID
15,437, // `(
39,691, // <expr4>
44,454, // `+
45,43, // <expr3>
46,129, // `-
48,286, // <expr2>
51,503, // <cast expr>
52,694, // <expr1>
53,751, // <unary expr>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 603
0x80000000|1, // match move
0x80000000|637, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 604
22,MIN_REDUCTION+55, // `[
91,MIN_REDUCTION+55, // "["
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 605
0x80000000|1, // match move
0x80000000|632, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 606
0x80000000|1, // match move
0x80000000|775, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 607
0x80000000|1, // match move
0x80000000|774, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 608
2,825, // ws*
22,MIN_REDUCTION+118, // `[
75,743, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+118, // "["
MIN_REDUCTION+118, // (default reduction)
  }
,
{ // state 609
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 610
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 611
2,828, // ws*
22,MIN_REDUCTION+118, // `[
75,742, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+118, // "["
MIN_REDUCTION+118, // (default reduction)
  }
,
{ // state 612
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 613
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 614
7,847, // ID
15,455, // `(
39,131, // <expr4>
44,475, // `+
45,427, // <expr3>
46,145, // `-
48,295, // <expr2>
51,491, // <cast expr>
52,665, // <expr1>
53,736, // <unary expr>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 615
7,846, // ID
15,457, // `(
39,159, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
88,123, // "-"
89,20, // "+"
  }
,
{ // state 616
7,147, // ID
55,378, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,744, // letter128
68,635, // {199..218 231..250}
69,635, // {193..198 225..230}
  }
,
{ // state 617
0x80000000|543, // match move
0x80000000|776, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 618
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 619
35,480, // `==
37,436, // `!=
79,389, // "@"
MIN_REDUCTION+23, // (default reduction)
  }
,
{ // state 620
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 621
2,607, // ws*
22,MIN_REDUCTION+148, // `[
75,743, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+148, // "["
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 622
2,559, // ws*
75,343, // ws
76,718, // " "
77,791, // {10}
MIN_REDUCTION+78, // (default reduction)
  }
,
{ // state 623
0x80000000|717, // match move
0x80000000|750, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 624
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 625
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 626
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 627
16,789, // `)
21,18, // <empty bracket pair>
22,849, // `[
85,641, // ")"
91,712, // "["
  }
,
{ // state 628
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 629
16,771, // `)
21,18, // <empty bracket pair>
22,849, // `[
85,641, // ")"
91,712, // "["
  }
,
{ // state 630
2,606, // ws*
22,MIN_REDUCTION+148, // `[
75,742, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+148, // "["
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 631
22,MIN_REDUCTION+124, // `[
91,MIN_REDUCTION+124, // "["
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 632
22,MIN_REDUCTION+95, // `[
75,851, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+95, // "["
MIN_REDUCTION+95, // (default reduction)
  }
,
{ // state 633
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 634
22,MIN_REDUCTION+124, // `[
91,MIN_REDUCTION+124, // "["
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 635
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 636
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 637
22,MIN_REDUCTION+95, // `[
75,850, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+95, // "["
MIN_REDUCTION+95, // (default reduction)
  }
,
{ // state 638
0x80000000|1, // match move
0x80000000|818, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 639
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 640
75,189, // ws
76,349, // " "
77,13, // {10}
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 641
2,354, // ws*
75,342, // ws
76,449, // " "
77,429, // {10}
MIN_REDUCTION+80, // (default reduction)
  }
,
{ // state 642
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 643
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 644
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,195, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,749, // digit128
74,567, // {176..185}
98,479, // idChar*
99,192, // $$0
104,165, // idChar
105,767, // "_"
106,161, // idChar128
107,702, // {223}
  }
,
{ // state 645
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 646
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 647
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 648
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 649
MIN_REDUCTION+129, // (default reduction)
  }
,
{ // state 650
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 651
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 652
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 653
9,400, // <decl in class>*
10,708, // `}
11,216, // <decl in class>
12,146, // <method decl>
13,796, // `public
78,745, // "#"
87,508, // "}"
  }
,
{ // state 654
75,89, // ws
76,609, // " "
77,484, // {10}
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 655
47,396, // `*
49,196, // `/
50,273, // `%
81,257, // "%"
83,266, // "*"
97,787, // "/"
MIN_REDUCTION+34, // (default reduction)
  }
,
{ // state 656
31,57, // `||
79,788, // "@"
MIN_REDUCTION+20, // (default reduction)
  }
,
{ // state 657
MIN_REDUCTION+16, // (default reduction)
  }
,
{ // state 658
MIN_REDUCTION+127, // (default reduction)
  }
,
{ // state 659
0x80000000|1, // match move
0x80000000|319, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 660
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 661
31,61, // `||
79,788, // "@"
MIN_REDUCTION+20, // (default reduction)
  }
,
{ // state 662
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,175, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,760, // digit128
74,527, // {176..185}
98,467, // idChar*
99,153, // $$0
104,165, // idChar
105,767, // "_"
106,277, // idChar128
107,693, // {223}
  }
,
{ // state 663
75,643, // ws
76,731, // " "
77,646, // {10}
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 664
0x80000000|1, // match move
0x80000000|232, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 665
0x80000000|1, // match move
0x80000000|233, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 666
55,428, // letter
56,40, // "p"
57,40, // "v"
58,40, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,40, // "c"
60,40, // "i"
61,40, // "l"
62,40, // "o"
63,40, // "u"
64,40, // "b"
65,40, // "n"
66,40, // "t"
67,180, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
70,187, // digit
71,168, // {"1".."9"}
72,168, // "0"
73,763, // digit128
74,529, // {176..185}
98,460, // idChar*
99,154, // $$0
104,165, // idChar
105,767, // "_"
106,283, // idChar128
107,688, // {223}
  }
,
{ // state 667
75,287, // ws
76,600, // " "
77,801, // {10}
111,MIN_REDUCTION+95, // $NT
  }
,
{ // state 668
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 669
75,120, // ws
76,580, // " "
77,769, // {10}
MIN_REDUCTION+87, // (default reduction)
  }
,
{ // state 670
0x80000000|1, // match move
0x80000000|358, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 671
2,654, // ws*
75,601, // ws
76,609, // " "
77,484, // {10}
MIN_REDUCTION+70, // (default reduction)
  }
,
{ // state 672
0x80000000|1, // match move
0x80000000|361, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 673
MIN_REDUCTION+139, // (default reduction)
  }
,
{ // state 674
22,MIN_REDUCTION+124, // `[
91,MIN_REDUCTION+124, // "["
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 675
0x80000000|1, // match move
0x80000000|810, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 676
7,530, // ID
55,262, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,826, // letter128
68,681, // {199..218 231..250}
69,681, // {193..198 225..230}
  }
,
{ // state 677
0x80000000|1, // match move
0x80000000|806, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 678
MIN_REDUCTION+53, // (default reduction)
  }
,
{ // state 679
7,352, // ID
8,713, // `{
10,524, // `}
15,457, // `(
18,829, // <type>
19,416, // `int
20,483, // `boolean
24,509, // <stmt>
25,585, // <assign>
27,248, // <local var decl>
28,238, // <expr>
30,661, // <expr8>
32,72, // <expr7>
34,67, // <expr6>
36,824, // <expr5>
39,489, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,588, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,834, // letter128
68,501, // {199..218 231..250}
69,501, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
78,329, // "#"
84,622, // "("
86,297, // "{"
87,499, // "}"
88,123, // "-"
89,20, // "+"
  }
,
{ // state 680
60,28, // "i"
64,167, // "b"
  }
,
{ // state 681
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 682
22,MIN_REDUCTION+113, // `[
91,MIN_REDUCTION+113, // "["
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 683
44,494, // `+
46,522, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+29, // (default reduction)
  }
,
{ // state 684
44,493, // `+
46,523, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+29, // (default reduction)
  }
,
{ // state 685
22,MIN_REDUCTION+113, // `[
91,MIN_REDUCTION+113, // "["
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 686
MIN_REDUCTION+136, // (default reduction)
  }
,
{ // state 687
31,78, // `||
79,788, // "@"
MIN_REDUCTION+20, // (default reduction)
  }
,
{ // state 688
0x80000000|626, // match move
0x80000000|842, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 689
2,17, // ws*
75,355, // ws
76,587, // " "
77,417, // {10}
MIN_REDUCTION+82, // (default reduction)
  }
,
{ // state 690
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 691
44,506, // `+
46,514, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+28, // (default reduction)
  }
,
{ // state 692
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 693
0x80000000|626, // match move
0x80000000|805, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 694
0x80000000|1, // match move
0x80000000|415, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 695
23,452, // `]
92,313, // "]"
  }
,
{ // state 696
23,672, // `]
92,240, // "]"
  }
,
{ // state 697
22,MIN_REDUCTION+113, // `[
91,MIN_REDUCTION+113, // "["
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 698
44,506, // `+
46,514, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+29, // (default reduction)
  }
,
{ // state 699
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 700
75,189, // ws
76,349, // " "
77,13, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 701
0x80000000|275, // match move
0x80000000|219, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 702
0x80000000|626, // match move
0x80000000|827, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 703
75,120, // ws
76,580, // " "
77,769, // {10}
MIN_REDUCTION+85, // (default reduction)
  }
,
{ // state 704
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 705
22,MIN_REDUCTION+52, // `[
91,MIN_REDUCTION+52, // "["
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 706
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 707
75,643, // ws
76,731, // " "
77,646, // {10}
MIN_REDUCTION+95, // (default reduction)
  }
,
{ // state 708
MIN_REDUCTION+5, // (default reduction)
  }
,
{ // state 709
2,381, // ws*
22,MIN_REDUCTION+144, // `[
75,94, // ws
76,332, // " "
77,143, // {10}
91,MIN_REDUCTION+144, // "["
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 710
22,MIN_REDUCTION+145, // `[
75,833, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+145, // "["
MIN_REDUCTION+145, // (default reduction)
  }
,
{ // state 711
23,659, // `]
92,302, // "]"
  }
,
{ // state 712
2,597, // ws*
75,199, // ws
76,250, // " "
77,636, // {10}
MIN_REDUCTION+94, // (default reduction)
  }
,
{ // state 713
7,352, // ID
8,713, // `{
10,657, // `}
15,457, // `(
17,679, // <stmt>*
18,829, // <type>
19,416, // `int
20,483, // `boolean
24,686, // <stmt>
25,585, // <assign>
27,248, // <local var decl>
28,238, // <expr>
30,661, // <expr8>
32,72, // <expr7>
34,67, // <expr6>
36,824, // <expr5>
39,489, // <expr4>
44,473, // `+
45,423, // <expr3>
46,141, // `-
48,299, // <expr2>
51,492, // <cast expr>
52,664, // <expr1>
53,737, // <unary expr>
54,179, // INTLIT
55,588, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,834, // letter128
68,501, // {199..218 231..250}
69,501, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
78,329, // "#"
84,622, // "("
86,297, // "{"
87,499, // "}"
88,123, // "-"
89,20, // "+"
  }
,
{ // state 714
22,MIN_REDUCTION+54, // `[
91,MIN_REDUCTION+54, // "["
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 715
22,MIN_REDUCTION+54, // `[
91,MIN_REDUCTION+54, // "["
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 716
22,MIN_REDUCTION+95, // `[
75,833, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+95, // "["
MIN_REDUCTION+95, // (default reduction)
  }
,
{ // state 717
2,360, // ws*
  }
,
{ // state 718
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 719
75,205, // ws
76,362, // " "
77,35, // {10}
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 720
75,202, // ws
76,367, // " "
77,32, // {10}
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 721
22,MIN_REDUCTION+128, // `[
91,MIN_REDUCTION+128, // "["
MIN_REDUCTION+128, // (default reduction)
  }
,
{ // state 722
75,317, // ws
76,222, // " "
77,652, // {10}
MIN_REDUCTION+77, // (default reduction)
  }
,
{ // state 723
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 724
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 725
75,610, // ws
76,88, // " "
77,14, // {10}
MIN_REDUCTION+93, // (default reduction)
  }
,
{ // state 726
23,670, // `]
92,239, // "]"
  }
,
{ // state 727
22,MIN_REDUCTION+54, // `[
91,MIN_REDUCTION+54, // "["
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 728
2,502, // ws*
  }
,
{ // state 729
75,350, // ws
76,263, // " "
77,724, // {10}
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 730
22,MIN_REDUCTION+145, // `[
75,851, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+145, // "["
MIN_REDUCTION+145, // (default reduction)
  }
,
{ // state 731
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 732
22,MIN_REDUCTION+145, // `[
75,850, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+145, // "["
MIN_REDUCTION+145, // (default reduction)
  }
,
{ // state 733
22,MIN_REDUCTION+128, // `[
91,MIN_REDUCTION+128, // "["
MIN_REDUCTION+128, // (default reduction)
  }
,
{ // state 734
22,MIN_REDUCTION+128, // `[
91,MIN_REDUCTION+128, // "["
MIN_REDUCTION+128, // (default reduction)
  }
,
{ // state 735
62,426, // "o"
  }
,
{ // state 736
MIN_REDUCTION+44, // (default reduction)
  }
,
{ // state 737
MIN_REDUCTION+44, // (default reduction)
  }
,
{ // state 738
75,610, // ws
76,88, // " "
77,14, // {10}
MIN_REDUCTION+89, // (default reduction)
  }
,
{ // state 739
65,386, // "n"
  }
,
{ // state 740
22,MIN_REDUCTION+142, // `[
91,MIN_REDUCTION+142, // "["
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 741
22,MIN_REDUCTION+142, // `[
91,MIN_REDUCTION+142, // "["
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 742
0x80000000|1, // match move
0x80000000|740, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 743
0x80000000|1, // match move
0x80000000|741, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 744
2,582, // ws*
75,7, // ws
76,224, // " "
77,651, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 745
56,79, // "p"
  }
,
{ // state 746
MIN_REDUCTION+134, // (default reduction)
  }
,
{ // state 747
75,326, // ws
76,39, // " "
77,109, // {10}
MIN_REDUCTION+87, // (default reduction)
  }
,
{ // state 748
75,488, // ws
76,448, // " "
77,47, // {10}
MIN_REDUCTION+81, // (default reduction)
  }
,
{ // state 749
0x80000000|288, // match move
0x80000000|68, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 750
2,360, // ws*
22,MIN_REDUCTION+146, // `[
75,743, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+146, // "["
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 751
MIN_REDUCTION+44, // (default reduction)
  }
,
{ // state 752
22,MIN_REDUCTION+142, // `[
91,MIN_REDUCTION+142, // "["
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 753
MIN_REDUCTION+8, // (default reduction)
  }
,
{ // state 754
0x80000000|1, // match move
0x80000000|441, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 755
2,407, // ws*
22,MIN_REDUCTION+112, // `[
75,742, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+112, // "["
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 756
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 757
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 758
2,406, // ws*
22,MIN_REDUCTION+112, // `[
75,743, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+112, // "["
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 759
66,249, // "t"
  }
,
{ // state 760
0x80000000|288, // match move
0x80000000|86, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 761
MIN_REDUCTION+42, // (default reduction)
  }
,
{ // state 762
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 763
0x80000000|288, // match move
0x80000000|84, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 764
62,395, // "o"
  }
,
{ // state 765
44,494, // `+
46,522, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+31, // (default reduction)
  }
,
{ // state 766
MIN_REDUCTION+4, // (default reduction)
  }
,
{ // state 767
MIN_REDUCTION+123, // (default reduction)
  }
,
{ // state 768
2,576, // ws*
75,209, // ws
76,236, // " "
77,650, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 769
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 770
44,493, // `+
46,523, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+31, // (default reduction)
  }
,
{ // state 771
7,846, // ID
15,457, // `(
51,835, // <cast expr>
52,531, // <expr1>
54,179, // INTLIT
55,666, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,410, // letter128
68,105, // {199..218 231..250}
69,105, // {193..198 225..230}
71,411, // {"1".."9"}
72,773, // "0"
73,243, // digit128
74,529, // {176..185}
84,622, // "("
  }
,
{ // state 772
56,658, // "p"
57,658, // "v"
58,658, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,658, // "c"
60,658, // "i"
61,658, // "l"
62,658, // "o"
63,658, // "u"
64,658, // "b"
65,658, // "n"
66,658, // "t"
69,574, // {193..198 225..230}
71,658, // {"1".."9"}
72,658, // "0"
74,574, // {176..185}
102,51, // hexDigit*
103,133, // $$2
108,746, // hexDigit
109,538, // hexDigit128
  }
,
{ // state 773
56,658, // "p"
57,658, // "v"
58,658, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,658, // "c"
60,658, // "i"
61,658, // "l"
62,658, // "o"
63,658, // "u"
64,658, // "b"
65,658, // "n"
66,658, // "t"
69,572, // {193..198 225..230}
71,658, // {"1".."9"}
72,658, // "0"
74,572, // {176..185}
102,45, // hexDigit*
103,134, // $$2
108,746, // hexDigit
109,540, // hexDigit128
  }
,
{ // state 774
22,MIN_REDUCTION+147, // `[
75,850, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+147, // "["
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 775
22,MIN_REDUCTION+147, // `[
75,851, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+147, // "["
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 776
2,363, // ws*
22,MIN_REDUCTION+146, // `[
75,742, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+146, // "["
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 777
62,391, // "o"
  }
,
{ // state 778
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 779
75,202, // ws
76,367, // " "
77,32, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 780
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 781
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 782
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 783
75,73, // ws
76,593, // " "
77,756, // {10}
MIN_REDUCTION+75, // (default reduction)
  }
,
{ // state 784
0x80000000|1, // match move
0x80000000|470, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 785
2,312, // ws*
22,MIN_REDUCTION+112, // `[
75,843, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+112, // "["
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 786
38,602, // `<
40,247, // `>
41,53, // `<=
42,365, // `>=
43,6, // `instanceof
78,83, // "#"
79,162, // "@"
94,815, // "<"
95,314, // ">"
MIN_REDUCTION+25, // (default reduction)
  }
,
{ // state 787
2,200, // ws*
75,563, // ws
76,593, // " "
77,756, // {10}
MIN_REDUCTION+110, // (default reduction)
  }
,
{ // state 788
93,397, // "|"
  }
,
{ // state 789
7,847, // ID
15,455, // `(
51,831, // <cast expr>
52,534, // <expr1>
54,182, // INTLIT
55,662, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,413, // letter128
68,107, // {199..218 231..250}
69,107, // {193..198 225..230}
71,393, // {"1".."9"}
72,772, // "0"
73,244, // digit128
74,527, // {176..185}
84,622, // "("
  }
,
{ // state 790
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 791
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 792
0x80000000|1, // match move
0x80000000|472, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 793
22,MIN_REDUCTION+125, // `[
91,MIN_REDUCTION+125, // "["
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 794
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 795
75,205, // ws
76,362, // " "
77,35, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 796
14,616, // `void
78,553, // "#"
  }
,
{ // state 797
MIN_REDUCTION+137, // (default reduction)
  }
,
{ // state 798
0x80000000|1, // match move
0x80000000|213, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 799
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 800
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 801
111,MIN_REDUCTION+56, // $NT
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 802
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 803
2,577, // ws*
22,MIN_REDUCTION+112, // `[
75,94, // ws
76,332, // " "
77,143, // {10}
91,MIN_REDUCTION+112, // "["
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 804
7,807, // ID
15,437, // `(
51,761, // <cast expr>
52,298, // <expr1>
54,194, // INTLIT
55,644, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,374, // letter128
68,92, // {199..218 231..250}
69,92, // {193..198 225..230}
71,227, // {"1".."9"}
72,808, // "0"
73,259, // digit128
74,567, // {176..185}
84,622, // "("
  }
,
{ // state 805
22,MIN_REDUCTION+126, // `[
91,MIN_REDUCTION+126, // "["
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 806
22,MIN_REDUCTION+56, // `[
91,MIN_REDUCTION+56, // "["
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 807
0x80000000|1, // match move
0x80000000|561, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 808
56,658, // "p"
57,658, // "v"
58,658, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,658, // "c"
60,658, // "i"
61,658, // "l"
62,658, // "o"
63,658, // "u"
64,658, // "b"
65,658, // "n"
66,658, // "t"
69,556, // {193..198 225..230}
71,658, // {"1".."9"}
72,658, // "0"
74,556, // {176..185}
102,24, // hexDigit*
103,163, // $$2
108,746, // hexDigit
109,566, // hexDigit128
  }
,
{ // state 809
22,MIN_REDUCTION+147, // `[
75,833, // ws
76,2, // " "
77,638, // {10}
91,MIN_REDUCTION+147, // "["
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 810
22,MIN_REDUCTION+56, // `[
91,MIN_REDUCTION+56, // "["
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 811
8,85, // `{
86,297, // "{"
  }
,
{ // state 812
75,37, // ws
76,794, // " "
77,613, // {10}
MIN_REDUCTION+61, // (default reduction)
  }
,
{ // state 813
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 814
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 815
2,562, // ws*
75,592, // ws
76,628, // " "
77,781, // {10}
MIN_REDUCTION+100, // (default reduction)
  }
,
{ // state 816
MIN_REDUCTION+18, // (default reduction)
  }
,
{ // state 817
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 818
22,MIN_REDUCTION+56, // `[
91,MIN_REDUCTION+56, // "["
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 819
0x80000000|408, // match move
0x80000000|520, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 820
22,MIN_REDUCTION+126, // `[
91,MIN_REDUCTION+126, // "["
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 821
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 822
38,602, // `<
40,247, // `>
41,53, // `<=
42,365, // `>=
43,6, // `instanceof
78,83, // "#"
79,162, // "@"
94,815, // "<"
95,314, // ">"
MIN_REDUCTION+26, // (default reduction)
  }
,
{ // state 823
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 824
38,615, // `<
40,385, // `>
41,75, // `<=
42,348, // `>=
43,112, // `instanceof
78,83, // "#"
79,162, // "@"
94,815, // "<"
95,314, // ">"
MIN_REDUCTION+27, // (default reduction)
  }
,
{ // state 825
0x80000000|1, // match move
0x80000000|191, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 826
2,729, // ws*
75,186, // ws
76,263, // " "
77,724, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 827
22,MIN_REDUCTION+126, // `[
91,MIN_REDUCTION+126, // "["
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 828
0x80000000|1, // match move
0x80000000|190, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 829
7,394, // ID
21,813, // <empty bracket pair>
22,30, // `[
55,434, // letter
56,495, // "p"
57,495, // "v"
58,495, // {"A".."Z" "a" "d".."h" "j".."k" "m" "q".."s" "w".."z"}
59,495, // "c"
60,495, // "i"
61,495, // "l"
62,495, // "o"
63,495, // "u"
64,495, // "b"
65,495, // "n"
66,495, // "t"
67,768, // letter128
68,648, // {199..218 231..250}
69,648, // {193..198 225..230}
91,712, // "["
  }
,
{ // state 830
MIN_REDUCTION+1, // (default reduction)
  }
,
{ // state 831
MIN_REDUCTION+42, // (default reduction)
  }
,
{ // state 832
38,614, // `<
40,388, // `>
41,80, // `<=
42,346, // `>=
43,114, // `instanceof
78,83, // "#"
79,162, // "@"
94,815, // "<"
95,314, // ">"
MIN_REDUCTION+27, // (default reduction)
  }
,
{ // state 833
0x80000000|1, // match move
0x80000000|401, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 834
0x80000000|198, // match move
0x80000000|803, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 835
MIN_REDUCTION+42, // (default reduction)
  }
,
{ // state 836
2,784, // ws*
22,MIN_REDUCTION+144, // `[
75,743, // ws
76,210, // " "
77,677, // {10}
91,MIN_REDUCTION+144, // "["
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 837
2,792, // ws*
22,MIN_REDUCTION+144, // `[
75,742, // ws
76,214, // " "
77,675, // {10}
91,MIN_REDUCTION+144, // "["
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 838
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 839
44,506, // `+
46,514, // `-
88,91, // "-"
89,170, // "+"
MIN_REDUCTION+31, // (default reduction)
  }
,
{ // state 840
75,326, // ws
76,39, // " "
77,109, // {10}
MIN_REDUCTION+85, // (default reduction)
  }
,
{ // state 841
66,369, // "t"
  }
,
{ // state 842
22,MIN_REDUCTION+126, // `[
91,MIN_REDUCTION+126, // "["
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 843
0x80000000|1, // match move
0x80000000|752, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 844
66,371, // "t"
  }
,
{ // state 845
2,156, // ws*
75,592, // ws
76,628, // " "
77,781, // {10}
MIN_REDUCTION+106, // (default reduction)
  }
,
{ // state 846
0x80000000|1, // match move
0x80000000|547, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 847
0x80000000|1, // match move
0x80000000|549, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 848
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 849
23,315, // `]
92,333, // "]"
  }
,
{ // state 850
0x80000000|1, // match move
0x80000000|380, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 851
0x80000000|1, // match move
0x80000000|384, // no-match move
0x80000000|21, // NT-test-match state for <empty bracket pair>
  }
,
};
}
public MJGrammarParseTable(MJGrammar actionObj) {
  actionObject = actionObj;
  parseTable = new int[852][];
  int doneSoFar = 0;
  doneSoFar += new Initter1().doInit(doneSoFar);
  doneSoFar += new Initter2().doInit(doneSoFar);
}
public int[] getProdTable() { return prodTable; }
private static int[] prodTable = {
// $$start ::= <start>
(0<<16)+1,
// <start> ::= ws* <program>
(1<<16)+2,
// <start> ::= <program>
(1<<16)+1,
// <program> ::= <class decl>+
(3<<16)+1,
// <class decl> ::= `class ID `{ <decl in class>* `}
(5<<16)+5,
// <class decl> ::= `class ID `{ `}
(5<<16)+4,
// <decl in class> ::= <method decl>
(11<<16)+1,
// <method decl> ::= `public `void ID `( `) `{ <stmt>* `}
(12<<16)+8,
// <method decl> ::= `public `void ID `( `) `{ `}
(12<<16)+7,
// <type> ::= `int
(18<<16)+1,
// <type> ::= `boolean
(18<<16)+1,
// <type> ::= ID
(18<<16)+1,
// <type> ::= <type> <empty bracket pair>
(18<<16)+2,
// <empty bracket pair> ::= `[ `]
(21<<16)+2,
// <stmt> ::= <assign> `;
(24<<16)+2,
// <stmt> ::= `{ <stmt>* `}
(24<<16)+3,
// <stmt> ::= `{ `}
(24<<16)+2,
// <stmt> ::= <local var decl> `;
(24<<16)+2,
// <assign> ::= <expr> `= <expr>
(25<<16)+3,
// <local var decl> ::= <type> ID `= <expr>
(27<<16)+4,
// <expr> ::= <expr8>
(28<<16)+1,
// <expr8> ::= <expr8> `|| <expr7>
(30<<16)+3,
// <expr8> ::= <expr7>
(30<<16)+1,
// <expr7> ::= <expr7> `&& <expr6>
(32<<16)+3,
// <expr7> ::= <expr6>
(32<<16)+1,
// <expr6> ::= <expr6> `== <expr5>
(34<<16)+3,
// <expr6> ::= <expr6> `!= <expr5>
(34<<16)+3,
// <expr6> ::= <expr5>
(34<<16)+1,
// <expr5> ::= <expr5> `< <expr4>
(36<<16)+3,
// <expr5> ::= <expr5> `> <expr4>
(36<<16)+3,
// <expr5> ::= <expr5> `<= <expr4>
(36<<16)+3,
// <expr5> ::= <expr5> `>= <expr4>
(36<<16)+3,
// <expr5> ::= <expr5> `instanceof <type>
(36<<16)+3,
// <expr5> ::= <expr4>
(36<<16)+1,
// <expr4> ::= <expr4> `+ <expr3>
(39<<16)+3,
// <expr4> ::= <expr4> `- <expr3>
(39<<16)+3,
// <expr4> ::= <expr3>
(39<<16)+1,
// <expr3> ::= <expr3> `* <expr2>
(45<<16)+3,
// <expr3> ::= <expr3> `/ <expr2>
(45<<16)+3,
// <expr3> ::= <expr3> `% <expr2>
(45<<16)+3,
// <expr3> ::= <expr2>
(45<<16)+1,
// <expr2> ::= <cast expr>
(48<<16)+1,
// <cast expr> ::= `( <type> `) <cast expr>
(51<<16)+4,
// <cast expr> ::= `( <type> `) <expr1>
(51<<16)+4,
// <expr2> ::= <unary expr>
(48<<16)+1,
// <unary expr> ::= `- <unary expr>
(53<<16)+2,
// <unary expr> ::= `+ <unary expr>
(53<<16)+2,
// <unary expr> ::= <expr1>
(53<<16)+1,
// <expr1> ::= ID
(52<<16)+1,
// <expr1> ::= <expr1> !<empty bracket pair> `[ <expr> `]
(52<<16)+4,
// <expr1> ::= INTLIT
(52<<16)+1,
// letter ::= {"A".."Z" "a".."z"}
(55<<16)+1,
// letter128 ::= {193..218 225..250}
(67<<16)+1,
// digit ::= {"0".."9"}
(70<<16)+1,
// digit128 ::= {176..185}
(73<<16)+1,
// ws ::= " "
(75<<16)+1,
// ws ::= {10}
(75<<16)+1,
// `boolean ::= "#" "b" "o" ws*
(20<<16)+4,
// `boolean ::= "#" "b" "o"
(20<<16)+3,
// `class ::= "#" "c" "l" ws*
(6<<16)+4,
// `class ::= "#" "c" "l"
(6<<16)+3,
// `void ::= "#" "v" "o" ws*
(14<<16)+4,
// `void ::= "#" "v" "o"
(14<<16)+3,
// `int ::= "#" "i" "t" ws*
(19<<16)+4,
// `int ::= "#" "i" "t"
(19<<16)+3,
// `instanceof ::= "#" "i" "n" ws*
(43<<16)+4,
// `instanceof ::= "#" "i" "n"
(43<<16)+3,
// `public ::= "#" "p" "u" ws*
(13<<16)+4,
// `public ::= "#" "p" "u"
(13<<16)+3,
// `!= ::= "@" "!" ws*
(37<<16)+3,
// `!= ::= "@" "!"
(37<<16)+2,
// `% ::= "%" ws*
(50<<16)+2,
// `% ::= "%"
(50<<16)+1,
// `&& ::= "@" "&" ws*
(33<<16)+3,
// `&& ::= "@" "&"
(33<<16)+2,
// `* ::= "*" ws*
(47<<16)+2,
// `* ::= "*"
(47<<16)+1,
// `( ::= "(" ws*
(15<<16)+2,
// `( ::= "("
(15<<16)+1,
// `) ::= ")" ws*
(16<<16)+2,
// `) ::= ")"
(16<<16)+1,
// `{ ::= "{" ws*
(8<<16)+2,
// `{ ::= "{"
(8<<16)+1,
// `} ::= "}" ws*
(10<<16)+2,
// `} ::= "}"
(10<<16)+1,
// `- ::= "-" ws*
(46<<16)+2,
// `- ::= "-"
(46<<16)+1,
// `+ ::= "+" ws*
(44<<16)+2,
// `+ ::= "+"
(44<<16)+1,
// `= ::= "=" ws*
(29<<16)+2,
// `= ::= "="
(29<<16)+1,
// `== ::= "@" "=" ws*
(35<<16)+3,
// `== ::= "@" "="
(35<<16)+2,
// `[ ::= "[" ws*
(22<<16)+2,
// `[ ::= "["
(22<<16)+1,
// `] ::= "]" ws*
(23<<16)+2,
// `] ::= "]"
(23<<16)+1,
// `|| ::= "@" "|" ws*
(31<<16)+3,
// `|| ::= "@" "|"
(31<<16)+2,
// `< ::= "<" ws*
(38<<16)+2,
// `< ::= "<"
(38<<16)+1,
// `<= ::= "@" "<" ws*
(41<<16)+3,
// `<= ::= "@" "<"
(41<<16)+2,
// `> ::= ">" !"=" ws*
(40<<16)+2,
// `> ::= ">" !"="
(40<<16)+1,
// `>= ::= "@" ">" ws*
(42<<16)+3,
// `>= ::= "@" ">"
(42<<16)+2,
// `; ::= ";" ws*
(26<<16)+2,
// `; ::= ";"
(26<<16)+1,
// `/ ::= "/" ws*
(49<<16)+2,
// `/ ::= "/"
(49<<16)+1,
// ID ::= letter128 ws*
(7<<16)+2,
// ID ::= letter128
(7<<16)+1,
// ID ::= letter idChar* $$0
(7<<16)+3,
// ID ::= letter $$0
(7<<16)+2,
// INTLIT ::= {"1".."9"} digit* $$1
(54<<16)+3,
// INTLIT ::= {"1".."9"} $$1
(54<<16)+2,
// INTLIT ::= digit128 ws*
(54<<16)+2,
// INTLIT ::= digit128
(54<<16)+1,
// INTLIT ::= "0" hexDigit* $$2
(54<<16)+3,
// INTLIT ::= "0" $$2
(54<<16)+2,
// idChar ::= letter
(104<<16)+1,
// idChar ::= digit
(104<<16)+1,
// idChar ::= "_"
(104<<16)+1,
// idChar128 ::= letter128
(106<<16)+1,
// idChar128 ::= digit128
(106<<16)+1,
// idChar128 ::= {223}
(106<<16)+1,
// hexDigit ::= {"0".."9" "A".."Z" "a".."z"}
(108<<16)+1,
// hexDigit128 ::= {176..185 193..198 225..230}
(109<<16)+1,
// digit* ::= digit* digit
(100<<16)+2,
// digit* ::= digit
(100<<16)+1,
// <decl in class>* ::= <decl in class>* <decl in class>
(9<<16)+2,
// <decl in class>* ::= <decl in class>
(9<<16)+1,
// hexDigit* ::= hexDigit* hexDigit
(102<<16)+2,
// hexDigit* ::= hexDigit
(102<<16)+1,
// <stmt>* ::= <stmt>* <stmt>
(17<<16)+2,
// <stmt>* ::= <stmt>
(17<<16)+1,
// idChar* ::= idChar* idChar
(98<<16)+2,
// idChar* ::= idChar
(98<<16)+1,
// <class decl>+ ::= <class decl>
(4<<16)+1,
// <class decl>+ ::= <class decl>+ <class decl>
(4<<16)+2,
// ws* ::= ws* ws
(2<<16)+2,
// ws* ::= ws
(2<<16)+1,
// $$0 ::= idChar128 ws*
(99<<16)+2,
// $$0 ::= idChar128
(99<<16)+1,
// $$1 ::= digit128 ws*
(101<<16)+2,
// $$1 ::= digit128
(101<<16)+1,
// $$2 ::= hexDigit128 ws*
(103<<16)+2,
// $$2 ::= hexDigit128
(103<<16)+1,
};
public int[] getCharMapTable() { return charMapTable; }
private static int[] charMapTable = {
-1, // 0
-1, // 1
-1, // 2
-1, // 3
-1, // 4
-1, // 5
-1, // 6
-1, // 7
-1, // 8
-1, // 9
77, // 10
-1, // 11
-1, // 12
-1, // 13
-1, // 14
-1, // 15
-1, // 16
-1, // 17
-1, // 18
-1, // 19
-1, // 20
-1, // 21
-1, // 22
-1, // 23
-1, // 24
-1, // 25
-1, // 26
-1, // 27
-1, // 28
-1, // 29
-1, // 30
-1, // 31
76, // " "
80, // "!"
-1, // '"'
78, // "#"
-1, // "$"
81, // "%"
82, // "&"
-1, // "'"
84, // "("
85, // ")"
83, // "*"
89, // "+"
-1, // ","
88, // "-"
-1, // "."
97, // "/"
72, // "0"
71, // "1"
71, // "2"
71, // "3"
71, // "4"
71, // "5"
71, // "6"
71, // "7"
71, // "8"
71, // "9"
-1, // ":"
96, // ";"
94, // "<"
90, // "="
95, // ">"
-1, // "?"
79, // "@"
58, // "A"
58, // "B"
58, // "C"
58, // "D"
58, // "E"
58, // "F"
58, // "G"
58, // "H"
58, // "I"
58, // "J"
58, // "K"
58, // "L"
58, // "M"
58, // "N"
58, // "O"
58, // "P"
58, // "Q"
58, // "R"
58, // "S"
58, // "T"
58, // "U"
58, // "V"
58, // "W"
58, // "X"
58, // "Y"
58, // "Z"
91, // "["
-1, // "\"
92, // "]"
-1, // "^"
105, // "_"
-1, // "`"
58, // "a"
64, // "b"
59, // "c"
58, // "d"
58, // "e"
58, // "f"
58, // "g"
58, // "h"
60, // "i"
58, // "j"
58, // "k"
61, // "l"
58, // "m"
65, // "n"
62, // "o"
56, // "p"
58, // "q"
58, // "r"
58, // "s"
66, // "t"
63, // "u"
57, // "v"
58, // "w"
58, // "x"
58, // "y"
58, // "z"
86, // "{"
93, // "|"
87, // "}"
-1, // "~"
-1, // 127
-1, // 128
-1, // 129
-1, // 130
-1, // 131
-1, // 132
-1, // 133
-1, // 134
-1, // 135
-1, // 136
-1, // 137
-1, // 138
-1, // 139
-1, // 140
-1, // 141
-1, // 142
-1, // 143
-1, // 144
-1, // 145
-1, // 146
-1, // 147
-1, // 148
-1, // 149
-1, // 150
-1, // 151
-1, // 152
-1, // 153
-1, // 154
-1, // 155
-1, // 156
-1, // 157
-1, // 158
-1, // 159
-1, // 160
-1, // 161
-1, // 162
-1, // 163
-1, // 164
-1, // 165
-1, // 166
-1, // 167
-1, // 168
-1, // 169
-1, // 170
-1, // 171
-1, // 172
-1, // 173
-1, // 174
-1, // 175
74, // 176
74, // 177
74, // 178
74, // 179
74, // 180
74, // 181
74, // 182
74, // 183
74, // 184
74, // 185
-1, // 186
-1, // 187
-1, // 188
-1, // 189
-1, // 190
-1, // 191
-1, // 192
69, // 193
69, // 194
69, // 195
69, // 196
69, // 197
69, // 198
68, // 199
68, // 200
68, // 201
68, // 202
68, // 203
68, // 204
68, // 205
68, // 206
68, // 207
68, // 208
68, // 209
68, // 210
68, // 211
68, // 212
68, // 213
68, // 214
68, // 215
68, // 216
68, // 217
68, // 218
-1, // 219
-1, // 220
-1, // 221
-1, // 222
107, // 223
-1, // 224
69, // 225
69, // 226
69, // 227
69, // 228
69, // 229
69, // 230
68, // 231
68, // 232
68, // 233
68, // 234
68, // 235
68, // 236
68, // 237
68, // 238
68, // 239
68, // 240
68, // 241
68, // 242
68, // 243
68, // 244
68, // 245
68, // 246
68, // 247
68, // 248
68, // 249
68, // 250
-1, // 251
-1, // 252
-1, // 253
-1, // 254
-1, // 255
};
public String[] getActionProdNameTable() { return actionProdNameTable; }
private String[] actionProdNameTable = {
"", // 0
"", // 1
"", // 2
"", // 3
"", // 4
"", // 5
"", // 6
"", // 7
"", // 8
"", // 9
"", // 10
"", // 11
"", // 12
"", // 13
"", // 14
"", // 15
"", // 16
"", // 17
"", // 18
"", // 19
"", // 20
"", // 21
"", // 22
"", // 23
"", // 24
"", // 25
"", // 26
"", // 27
"", // 28
"", // 29
"", // 30
"", // 31
"", // 32
"", // 33
"", // 34
"", // 35
"", // 36
"", // 37
"", // 38
"", // 39
"", // 40
"", // 41
"", // 42
"", // 43
"", // 44
"", // 45
"", // 46
"", // 47
"", // 48
"", // 49
"", // 50
"", // 51
"", // 52
"", // 53
"", // 54
"", // 55
"", // 56
"", // 57
"", // 58
"", // 59
"", // 60
"", // 61
"", // 62
"", // 63
"", // 64
"", // 65
"", // 66
"", // 67
"", // 68
"", // 69
"", // 70
"", // 71
"", // 72
"", // 73
"", // 74
"", // 75
"", // 76
"", // 77
"", // 78
"", // 79
"", // 80
"", // 81
"", // 82
"", // 83
"", // 84
"", // 85
"", // 86
"", // 87
"", // 88
"", // 89
"", // 90
"", // 91
"", // 92
"", // 93
"", // 94
"", // 95
"", // 96
"", // 97
"", // 98
"", // 99
"", // 100
"", // 101
"", // 102
"", // 103
"", // 104
"", // 105
"", // 106
"", // 107
"", // 108
"", // 109
"", // 110
"", // 111
"", // 112
"", // 113
"", // 114
"", // 115
"", // 116
"", // 117
"", // 118
"", // 119
"", // 120
"", // 121
"", // 122
"", // 123
"", // 124
"", // 125
"", // 126
"", // 127
"", // 128
"digit* ::= digit* digit", // 129
"digit* ::= digit* digit", // 130
"<decl in class>* ::= <decl in class>* <decl in class>", // 131
"<decl in class>* ::= <decl in class>* <decl in class>", // 132
"hexDigit* ::= hexDigit* hexDigit", // 133
"hexDigit* ::= hexDigit* hexDigit", // 134
"<stmt>* ::= <stmt>* <stmt>", // 135
"<stmt>* ::= <stmt>* <stmt>", // 136
"idChar* ::= idChar* idChar", // 137
"idChar* ::= idChar* idChar", // 138
"<class decl>+ ::= <class decl>", // 139
"<class decl>+ ::= <class decl>+ <class decl>", // 140
"ws* ::= ws* ws", // 141
"ws* ::= ws* ws", // 142
"", // 143
"", // 144
"", // 145
"", // 146
"", // 147
"", // 148
};
public int[][] getActionTable() { return actionTable; }
private int[][] actionTable = {
    { // 0: $$start ::= <start> @pass
      ((1<<5)|0xe)/*popPos:1*/,
    },
    { // 1: <start> ::= ws* <program> @topLevel(Program)=>
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((0<<5)|0x5)/*methodCall:0*/,
    },
    { // 2: <start> ::= [ws*] <program> @topLevel(Program)=>
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((0<<5)|0x5)/*methodCall:0*/,
    },
    { // 3: <program> ::= [#] <class decl>+ @createProgram(int,List<ClassDecl>)=>Program
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0x5)/*methodCall:1*/,
    },
    { // 4: <class decl> ::= `class [#] ID `{ <decl in class>* `} @createClassDecl(int,String,List<Decl>)=>ClassDecl
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((2<<5)|0x5)/*methodCall:2*/,
    },
    { // 5: <class decl> ::= `class [#] ID `{ [<decl in class>*] `} @createClassDecl(int,String,List<Decl>)=>ClassDecl
      ((1<<5)|0xe)/*popPos:1*/,
      ((2<<5)|0x6)/*nullProductionAction:2*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((2<<5)|0x5)/*methodCall:2*/,
    },
    { // 6: <decl in class> ::= <method decl> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 7: <method decl> ::= `public `void [#] ID `( `) `{ <stmt>* `} @createMethodDeclVoid(int,String,List<Stmt>)=>Decl
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((3<<5)|0x5)/*methodCall:3*/,
    },
    { // 8: <method decl> ::= `public `void [#] ID `( `) `{ [<stmt>*] `} @createMethodDeclVoid(int,String,List<Stmt>)=>Decl
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x6)/*nullProductionAction:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((3<<5)|0x5)/*methodCall:3*/,
    },
    { // 9: <type> ::= [#] `int @intType(int)=>Type
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((4<<5)|0x5)/*methodCall:4*/,
    },
    { // 10: <type> ::= [#] `boolean @booleanType(int)=>Type
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((5<<5)|0x5)/*methodCall:5*/,
    },
    { // 11: <type> ::= [#] ID @idType(int,String)=>Type
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((6<<5)|0x5)/*methodCall:6*/,
    },
    { // 12: <type> ::= [#] <type> <empty bracket pair> @newArrayType(int,Type,Object)=>Type
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((7<<5)|0x5)/*methodCall:7*/,
    },
    { // 13: <empty bracket pair> ::= `[ `] @null
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x8)/*nullPointer:1*/,
    },
    { // 14: <stmt> ::= <assign> `; @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 15: <stmt> ::= [#] `{ <stmt>* `} @newBlock(int,List<Stmt>)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((8<<5)|0x5)/*methodCall:8*/,
    },
    { // 16: <stmt> ::= [#] `{ [<stmt>*] `} @newBlock(int,List<Stmt>)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x6)/*nullProductionAction:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((8<<5)|0x5)/*methodCall:8*/,
    },
    { // 17: <stmt> ::= <local var decl> `; @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 18: <assign> ::= <expr> [#] `= <expr> @assign(Exp,int,Exp)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((9<<5)|0x5)/*methodCall:9*/,
    },
    { // 19: <local var decl> ::= <type> [#] ID `= <expr> @localVarDecl(Type,int,String,Exp)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((10<<5)|0x5)/*methodCall:10*/,
    },
    { // 20: <expr> ::= <expr8> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 21: <expr8> ::= <expr8> [#] `|| <expr7> @newOr(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((11<<5)|0x5)/*methodCall:11*/,
    },
    { // 22: <expr8> ::= <expr7> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 23: <expr7> ::= <expr7> [#] `&& <expr6> @newAnd(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((12<<5)|0x5)/*methodCall:12*/,
    },
    { // 24: <expr7> ::= <expr6> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 25: <expr6> ::= <expr6> [#] `== <expr5> @newEqualEqual(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((13<<5)|0x5)/*methodCall:13*/,
    },
    { // 26: <expr6> ::= <expr6> [#] `!= <expr5> @newNotEquals(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((14<<5)|0x5)/*methodCall:14*/,
    },
    { // 27: <expr6> ::= <expr5> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 28: <expr5> ::= <expr5> [#] `< <expr4> @newLessThan(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((15<<5)|0x5)/*methodCall:15*/,
    },
    { // 29: <expr5> ::= <expr5> [#] `> <expr4> @newGreaterThan(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((16<<5)|0x5)/*methodCall:16*/,
    },
    { // 30: <expr5> ::= <expr5> [#] `<= <expr4> @newLessThanEqual(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((17<<5)|0x5)/*methodCall:17*/,
    },
    { // 31: <expr5> ::= <expr5> [#] `>= <expr4> @newGreaterThanEqual(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((18<<5)|0x5)/*methodCall:18*/,
    },
    { // 32: <expr5> ::= <expr5> [#] `instanceof <type> @newInstanceof(Exp,int,Type)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((19<<5)|0x5)/*methodCall:19*/,
    },
    { // 33: <expr5> ::= <expr4> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 34: <expr4> ::= <expr4> [#] `+ <expr3> @newPlus(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((20<<5)|0x5)/*methodCall:20*/,
    },
    { // 35: <expr4> ::= <expr4> [#] `- <expr3> @newMinus(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((21<<5)|0x5)/*methodCall:21*/,
    },
    { // 36: <expr4> ::= <expr3> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 37: <expr3> ::= <expr3> [#] `* <expr2> @newTimes(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((22<<5)|0x5)/*methodCall:22*/,
    },
    { // 38: <expr3> ::= <expr3> [#] `/ <expr2> @newDivide(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((23<<5)|0x5)/*methodCall:23*/,
    },
    { // 39: <expr3> ::= <expr3> [#] `% <expr2> @newMod(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((24<<5)|0x5)/*methodCall:24*/,
    },
    { // 40: <expr3> ::= <expr2> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 41: <expr2> ::= <cast expr> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 42: <cast expr> ::= [#] `( <type> `) <cast expr> @newCast(int,Type,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((25<<5)|0x5)/*methodCall:25*/,
    },
    { // 43: <cast expr> ::= [#] `( <type> `) <expr1> @newCast(int,Type,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((25<<5)|0x5)/*methodCall:25*/,
    },
    { // 44: <expr2> ::= <unary expr> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 45: <unary expr> ::= [#] `- <unary expr> @newUnaryMinus(int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((26<<5)|0x5)/*methodCall:26*/,
    },
    { // 46: <unary expr> ::= [#] `+ <unary expr> @newUnaryPlus(int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((27<<5)|0x5)/*methodCall:27*/,
    },
    { // 47: <unary expr> ::= <expr1> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 48: <expr1> ::= [#] ID @newIDExp(int,String)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((28<<5)|0x5)/*methodCall:28*/,
    },
    { // 49: <expr1> ::= <expr1> !<empty bracket pair> [#] `[ <expr> `] @newArrayLookup(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((29<<5)|0x5)/*methodCall:29*/,
    },
    { // 50: <expr1> ::= [#] INTLIT @newIntLit(int,int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((30<<5)|0x5)/*methodCall:30*/,
    },
    { // 51: letter ::= {"A".."Z" "a".."z"} @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 52: letter128 ::= {193..218 225..250} @sub128(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((31<<5)|0x5)/*methodCall:31*/,
    },
    { // 53: digit ::= {"0".."9"} @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 54: digit128 ::= {176..185} @sub128(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((31<<5)|0x5)/*methodCall:31*/,
    },
    { // 55: ws ::= " " @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 56: ws ::= {10} [registerNewline] @void
      ((7<<5)|0x6)/*nullProductionAction:7*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 57: `boolean ::= "#" "b" "o" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 58: `boolean ::= "#" "b" "o" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 59: `class ::= "#" "c" "l" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 60: `class ::= "#" "c" "l" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 61: `void ::= "#" "v" "o" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 62: `void ::= "#" "v" "o" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 63: `int ::= "#" "i" "t" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 64: `int ::= "#" "i" "t" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 65: `instanceof ::= "#" "i" "n" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 66: `instanceof ::= "#" "i" "n" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 67: `public ::= "#" "p" "u" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 68: `public ::= "#" "p" "u" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 69: `!= ::= "@" "!" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 70: `!= ::= "@" "!" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 71: `% ::= "%" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 72: `% ::= "%" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 73: `&& ::= "@" "&" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 74: `&& ::= "@" "&" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 75: `* ::= "*" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 76: `* ::= "*" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 77: `( ::= "(" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 78: `( ::= "(" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 79: `) ::= ")" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 80: `) ::= ")" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 81: `{ ::= "{" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 82: `{ ::= "{" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 83: `} ::= "}" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 84: `} ::= "}" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 85: `- ::= "-" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 86: `- ::= "-" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 87: `+ ::= "+" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 88: `+ ::= "+" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 89: `= ::= "=" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 90: `= ::= "=" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 91: `== ::= "@" "=" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 92: `== ::= "@" "=" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 93: `[ ::= "[" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 94: `[ ::= "[" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 95: `] ::= "]" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 96: `] ::= "]" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 97: `|| ::= "@" "|" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 98: `|| ::= "@" "|" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 99: `< ::= "<" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 100: `< ::= "<" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 101: `<= ::= "@" "<" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 102: `<= ::= "@" "<" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 103: `> ::= ">" !"=" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 104: `> ::= ">" !"=" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 105: `>= ::= "@" ">" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 106: `>= ::= "@" ">" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 107: `; ::= ";" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 108: `; ::= ";" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 109: `/ ::= "/" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 110: `/ ::= "/" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 111: ID ::= letter128 ws* @text
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x4)/*stringConcat:1*/,
    },
    { // 112: ID ::= letter128 [ws*] @text
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x4)/*stringConcat:1*/,
    },
    { // 113: ID ::= letter idChar* $$0 @text
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x4)/*stringConcat:3*/,
    },
    { // 114: ID ::= letter [idChar*] $$0 @text
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((4<<5)|0x6)/*nullProductionAction:4*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x4)/*stringConcat:3*/,
    },
    { // 115: INTLIT ::= {"1".."9"} digit* $$1 @convertToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((32<<5)|0x5)/*methodCall:32*/,
    },
    { // 116: INTLIT ::= {"1".."9"} [digit*] $$1 @convertToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((32<<5)|0x5)/*methodCall:32*/,
    },
    { // 117: INTLIT ::= digit128 ws* @convertToInt(char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((33<<5)|0x5)/*methodCall:33*/,
    },
    { // 118: INTLIT ::= digit128 [ws*] @convertToInt(char)=>int
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((33<<5)|0x5)/*methodCall:33*/,
    },
    { // 119: INTLIT ::= "0" hexDigit* $$2 @convert16ToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((34<<5)|0x5)/*methodCall:34*/,
    },
    { // 120: INTLIT ::= "0" [hexDigit*] $$2 @convert16ToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((0<<5)|0x6)/*nullProductionAction:0*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((34<<5)|0x5)/*methodCall:34*/,
    },
    { // 121: idChar ::= letter @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 122: idChar ::= digit @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 123: idChar ::= "_" @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 124: idChar128 ::= letter128 @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 125: idChar128 ::= digit128 @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 126: idChar128 ::= {223} @underscore(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((35<<5)|0x5)/*methodCall:35*/,
    },
    { // 127: hexDigit ::= {"0".."9" "A".."Z" "a".."z"} @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 128: hexDigit128 ::= {176..185 193..198 225..230} @sub128(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((31<<5)|0x5)/*methodCall:31*/,
    },
    { // 129: digit* ::= digit* digit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 130: digit* ::= [digit*] digit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 131: <decl in class>* ::= <decl in class>* <decl in class> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 132: <decl in class>* ::= [<decl in class>*] <decl in class> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x6)/*nullProductionAction:2*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 133: hexDigit* ::= hexDigit* hexDigit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 134: hexDigit* ::= [hexDigit*] hexDigit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((0<<5)|0x6)/*nullProductionAction:0*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 135: <stmt>* ::= <stmt>* <stmt> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 136: <stmt>* ::= [<stmt>*] <stmt> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x6)/*nullProductionAction:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 137: idChar* ::= idChar* idChar @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 138: idChar* ::= [idChar*] idChar @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((4<<5)|0x6)/*nullProductionAction:4*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 139: <class decl>+ ::= <class decl> @singleList
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xa)/*singleList:1*/,
    },
    { // 140: <class decl>+ ::= <class decl>+ <class decl> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 141: ws* ::= ws* ws @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
    },
    { // 142: ws* ::= [ws*] ws @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((3<<5)|0x6)/*nullProductionAction:3*/,
    },
    { // 143: $$0 ::= idChar128 ws* @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 144: $$0 ::= idChar128 [ws*] @pass
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 145: $$1 ::= digit128 ws* @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 146: $$1 ::= digit128 [ws*] @pass
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 147: $$2 ::= hexDigit128 ws* @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 148: $$2 ::= hexDigit128 [ws*] @pass
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
};
public String[] getNullProdNameTable() { return nullProdNameTable; }
private String[] nullProdNameTable = {
    "hexDigit* ::=", // hexDigit*
    "<stmt>* ::=", // <stmt>*
    "<decl in class>* ::=", // <decl in class>*
    "ws* ::=", // ws*
    "idChar* ::=", // idChar*
    "digit* ::=", // digit*
    "# ::=", // #
    "", // registerNewline
};
public int[][] getNullProductionActionTable() { return nullActionTable; }
private int[][] nullActionTable = {
    { // hexDigit*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // <stmt>*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // <decl in class>*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // ws*
    },
    { // idChar*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // digit*
      ((1<<5)|0x9)/*emptyList:1*/,
    },
    { // #
      7/*duplicateTop*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // registerNewline
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((36<<5)|0x5)/*methodCall:36*/,
    },
};
public void actionCall(int idx, wrangLR.runtime.SemanticInfo si) {
  switch(idx) {
    default: System.err.println("Internal error--illegal action number: "+idx);break;
    case 0: {
      Program parm0 = (Program)si.popPb();
      actionObject.topLevel(parm0);
    }
    break;
    case 1: {
      int parm0 = (Integer)si.popPb();
      List<ClassDecl> parm1 = (List<ClassDecl>)si.popPb();
      Program result = actionObject.createProgram(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 2: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      List<Decl> parm2 = (List<Decl>)si.popPb();
      ClassDecl result = actionObject.createClassDecl(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 3: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      List<Stmt> parm2 = (List<Stmt>)si.popPb();
      Decl result = actionObject.createMethodDeclVoid(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 4: {
      int parm0 = (Integer)si.popPb();
      Type result = actionObject.intType(parm0);
      si.pushPb(result);
    }
    break;
    case 5: {
      int parm0 = (Integer)si.popPb();
      Type result = actionObject.booleanType(parm0);
      si.pushPb(result);
    }
    break;
    case 6: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Type result = actionObject.idType(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 7: {
      int parm0 = (Integer)si.popPb();
      Type parm1 = (Type)si.popPb();
      Object parm2 = (Object)si.popPb();
      Type result = actionObject.newArrayType(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 8: {
      int parm0 = (Integer)si.popPb();
      List<Stmt> parm1 = (List<Stmt>)si.popPb();
      Stmt result = actionObject.newBlock(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 9: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Stmt result = actionObject.assign(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 10: {
      Type parm0 = (Type)si.popPb();
      int parm1 = (Integer)si.popPb();
      String parm2 = (String)si.popPb();
      Exp parm3 = (Exp)si.popPb();
      Stmt result = actionObject.localVarDecl(parm0,parm1,parm2,parm3);
      si.pushPb(result);
    }
    break;
    case 11: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newOr(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 12: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newAnd(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 13: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newEqualEqual(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 14: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newNotEquals(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 15: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newLessThan(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 16: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newGreaterThan(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 17: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newLessThanEqual(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 18: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newGreaterThanEqual(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 19: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Type parm2 = (Type)si.popPb();
      Exp result = actionObject.newInstanceof(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 20: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newPlus(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 21: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newMinus(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 22: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newTimes(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 23: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newDivide(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 24: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newMod(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 25: {
      int parm0 = (Integer)si.popPb();
      Type parm1 = (Type)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newCast(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 26: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      Exp result = actionObject.newUnaryMinus(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 27: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      Exp result = actionObject.newUnaryPlus(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 28: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Exp result = actionObject.newIDExp(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 29: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newArrayLookup(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 30: {
      int parm0 = (Integer)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp result = actionObject.newIntLit(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 31: {
      char parm0 = (Character)si.popPb();
      char result = actionObject.sub128(parm0);
      si.pushPb(result);
    }
    break;
    case 32: {
      char parm0 = (Character)si.popPb();
      List<Character> parm1 = (List<Character>)si.popPb();
      char parm2 = (Character)si.popPb();
      int result = actionObject.convertToInt(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 33: {
      char parm0 = (Character)si.popPb();
      int result = actionObject.convertToInt(parm0);
      si.pushPb(result);
    }
    break;
    case 34: {
      char parm0 = (Character)si.popPb();
      List<Character> parm1 = (List<Character>)si.popPb();
      char parm2 = (Character)si.popPb();
      int result = actionObject.convert16ToInt(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 35: {
      char parm0 = (Character)si.popPb();
      char result = actionObject.underscore(parm0);
      si.pushPb(result);
    }
    break;
    case 36: {
      int parm0 = (Integer)si.popPb();
      actionObject.registerNewline(parm0);
    }
    break;
  }
}
private String[] saNameSigTable = {
"void topLevel(Program)",
"Program createProgram(int,List<ClassDecl>)",
"ClassDecl createClassDecl(int,String,List<Decl>)",
"Decl createMethodDeclVoid(int,String,List<Stmt>)",
"Type intType(int)",
"Type booleanType(int)",
"Type idType(int,String)",
"Type newArrayType(int,Type,Object)",
"Stmt newBlock(int,List<Stmt>)",
"Stmt assign(Exp,int,Exp)",
"Stmt localVarDecl(Type,int,String,Exp)",
"Exp newOr(Exp,int,Exp)",
"Exp newAnd(Exp,int,Exp)",
"Exp newEqualEqual(Exp,int,Exp)",
"Exp newNotEquals(Exp,int,Exp)",
"Exp newLessThan(Exp,int,Exp)",
"Exp newGreaterThan(Exp,int,Exp)",
"Exp newLessThanEqual(Exp,int,Exp)",
"Exp newGreaterThanEqual(Exp,int,Exp)",
"Exp newInstanceof(Exp,int,Type)",
"Exp newPlus(Exp,int,Exp)",
"Exp newMinus(Exp,int,Exp)",
"Exp newTimes(Exp,int,Exp)",
"Exp newDivide(Exp,int,Exp)",
"Exp newMod(Exp,int,Exp)",
"Exp newCast(int,Type,Exp)",
"Exp newUnaryMinus(int,Exp)",
"Exp newUnaryPlus(int,Exp)",
"Exp newIDExp(int,String)",
"Exp newArrayLookup(Exp,int,Exp)",
"Exp newIntLit(int,int)",
"char sub128(char)",
"int convertToInt(char,List<Character>,char)",
"int convertToInt(char)",
"int convert16ToInt(char,List<Character>,char)",
"char underscore(char)",
"void registerNewline(int)",
};
public String[] getSaNameSigTable() {
  return saNameSigTable;
}
private int[] sigCountTable = {
1,0,
2,1,
3,1,
3,1,
1,1,
1,1,
2,1,
3,1,
2,1,
3,1,
4,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
3,1,
2,1,
2,1,
2,1,
3,1,
2,1,
1,1,
3,1,
1,1,
3,1,
1,1,
1,0,
};
public int[] getSigCountTable() {
  return sigCountTable;
}
public int[] getSymbolSizeTable() { return symbolSizeTable; }
private int[] symbolSizeTable = {
    0,
    0,
    0,
    1,
    1,
    1,
    0,
    1,
    0,
    1,
    0,
    1,
    1,
    0,
    0,
    0,
    0,
    1,
    1,
    0,
    0,
    1,
    0,
    0,
    1,
    1,
    0,
    1,
    1,
    0,
    1,
    0,
    1,
    0,
    1,
    0,
    1,
    0,
    0,
    1,
    0,
    0,
    0,
    0,
    0,
    1,
    0,
    0,
    1,
    0,
    0,
    1,
    1,
    1,
    1,
    1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    1,
    -1,
    -1,
    1,
    -1,
    -1,
    1,
    -1,
    0,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    -1,
    1,
    1,
    1,
    1,
    1,
    1,
    1,
    -1,
    1,
    -1,
    1,
    1,
    -1,
    -1,
};
public Object vectorToTuple(java.util.ArrayList<Object> vec) {
  switch (vec.size()) {
  }
  System.err.println("Internal error--illegal Tuple size: "+vec.size());
  return null;
}
}
