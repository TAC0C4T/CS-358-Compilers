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
public int getEofSym() { return 127; }
public int getNttSym() { return 128; }
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
"`break",
"`++",
"`--",
"`if",
"<expr>",
"`else",
"<local var decl>",
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
"`!",
"`.",
"INTLIT",
"`true",
"`false",
"`null",
"`this",
"letter",
"\"a\"",
"\"p\"",
"\"v\"",
"\"c\"",
"\"f\"",
"\"i\"",
"\"l\"",
"\"o\"",
"\"r\"",
"\"u\"",
"\"b\"",
"\"e\"",
"{\"A\"..\"Z\" \"d\" \"g\" \"j\"..\"k\" \"m\" \"q\" \"s\" \"w\"..\"z\"}",
"\"h\"",
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
"\"+\"",
"\"!\"",
"\"@\"",
"\"%\"",
"\"&\"",
"\"*\"",
"\"(\"",
"\")\"",
"\"{\"",
"\"}\"",
"\"-\"",
"\"=\"",
"\"[\"",
"\"]\"",
"\"|\"",
"\"<\"",
"\">\"",
"\".\"",
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
public int numSymbols() { return 129;}
private static final int MIN_REDUCTION = 1394;
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
1,626, // <start>
2,945, // ws*
3,519, // <program>
4,465, // <class decl>+
5,1145, // <class decl>
6,1150, // `class
91,533, // ws
92,872, // " "
93,752, // {10}
94,224, // "#"
  }
,
{ // state 1
  }
,
{ // state 2
0x80000000|898, // match move
0x80000000|457, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 3
23,318, // `]
108,1347, // "]"
  }
,
{ // state 4
22,MIN_REDUCTION+84, // `[
91,722, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+84, // "["
MIN_REDUCTION+84, // (default reduction)
  }
,
{ // state 5
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+140, // (default reduction)
  }
,
{ // state 6
0x80000000|1063, // match move
0x80000000|370, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 7
22,MIN_REDUCTION+160, // `[
107,MIN_REDUCTION+160, // "["
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 8
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 9
0x80000000|1, // match move
0x80000000|849, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 10
22,MIN_REDUCTION+160, // `[
107,MIN_REDUCTION+160, // "["
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 11
91,335, // ws
92,609, // " "
93,41, // {10}
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 12
7,239, // ID
18,512, // <type>
19,576, // `int
20,460, // `boolean
66,434, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,483, // letter128
84,989, // {199..218 231..250}
85,989, // {193..198 225..230}
94,584, // "#"
  }
,
{ // state 13
MIN_REDUCTION+21, // (default reduction)
  }
,
{ // state 14
0x80000000|1, // match move
0x80000000|852, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 15
0x80000000|898, // match move
0x80000000|459, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 16
2,802, // ws*
91,1292, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 17
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 18
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 19
23,374, // `]
108,1373, // "]"
  }
,
{ // state 20
23,377, // `]
108,1366, // "]"
  }
,
{ // state 21
72,1327, // "i"
77,1309, // "b"
  }
,
{ // state 22
0x80000000|898, // match move
0x80000000|1017, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 23
26,431, // `;
113,34, // ";"
  }
,
{ // state 24
22,MIN_REDUCTION+177, // `[
107,MIN_REDUCTION+177, // "["
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 25
22,MIN_REDUCTION+160, // `[
107,MIN_REDUCTION+160, // "["
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 26
71,893, // "f"
81,1058, // "n"
82,1349, // "t"
  }
,
{ // state 27
7,956, // ID
8,182, // `{
15,774, // `(
18,1367, // <type>
19,704, // `int
20,820, // `boolean
24,430, // <stmt>
25,973, // <assign>
27,1154, // `break
28,168, // `++
29,132, // `--
30,832, // `if
31,425, // <expr>
33,796, // <local var decl>
35,1130, // <expr8>
37,124, // <expr7>
39,116, // <expr6>
41,1361, // <expr5>
44,836, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,313, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1185, // letter128
84,422, // {199..218 231..250}
85,422, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,1068, // "#"
95,50, // "+"
96,1186, // "!"
97,331, // "@"
101,1067, // "("
103,527, // "{"
105,205, // "-"
  }
,
{ // state 28
0x80000000|1063, // match move
0x80000000|259, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 29
0x80000000|1063, // match move
0x80000000|256, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 30
7,1103, // ID
49,745, // `+
51,244, // `-
57,711, // <expr1>
58,966, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 31
22,MIN_REDUCTION+84, // `[
91,701, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+84, // "["
MIN_REDUCTION+84, // (default reduction)
  }
,
{ // state 32
0x80000000|264, // match move
0x80000000|1278, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 33
22,MIN_REDUCTION+160, // `[
107,MIN_REDUCTION+160, // "["
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 34
0x80000000|288, // match move
0x80000000|707, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 35
2,706, // ws*
91,499, // ws
92,1310, // " "
93,1054, // {10}
MIN_REDUCTION+73, // (default reduction)
  }
,
{ // state 36
43,1056, // `<
45,659, // `>
46,127, // `<=
47,608, // `>=
48,183, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+32, // (default reduction)
  }
,
{ // state 37
22,MIN_REDUCTION+84, // `[
91,708, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+84, // "["
MIN_REDUCTION+84, // (default reduction)
  }
,
{ // state 38
91,582, // ws
92,764, // " "
93,855, // {10}
MIN_REDUCTION+102, // (default reduction)
  }
,
{ // state 39
0x80000000|1, // match move
0x80000000|842, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 40
2,678, // ws*
91,1010, // ws
92,1074, // " "
93,1290, // {10}
MIN_REDUCTION+131, // (default reduction)
  }
,
{ // state 41
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 42
0x80000000|1240, // match move
0x80000000|585, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 43
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 44
0x80000000|1238, // match move
0x80000000|583, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 45
91,586, // ws
92,1003, // " "
93,705, // {10}
MIN_REDUCTION+110, // (default reduction)
  }
,
{ // state 46
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 47
0x80000000|1, // match move
0x80000000|899, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 48
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 49
0x80000000|1, // match move
0x80000000|902, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 50
2,1248, // ws*
91,1100, // ws
92,82, // " "
93,179, // {10}
MIN_REDUCTION+117, // (default reduction)
  }
,
{ // state 51
22,1173, // `[
107,1202, // "["
  }
,
{ // state 52
128,MIN_REDUCTION+177, // $NT
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 53
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 54
7,1111, // ID
15,771, // `(
39,958, // <expr6>
41,1372, // <expr5>
44,830, // <expr4>
49,801, // `+
50,723, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 55
2,283, // ws*
22,MIN_REDUCTION+125, // `[
91,1164, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+125, // "["
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 56
7,1115, // ID
15,774, // `(
39,962, // <expr6>
41,1361, // <expr5>
44,836, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 57
0x80000000|1377, // match move
0x80000000|1019, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 58
82,219, // "t"
  }
,
{ // state 59
94,532, // "#"
  }
,
{ // state 60
0x80000000|1, // match move
0x80000000|795, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 61
23,785, // `]
108,119, // "]"
  }
,
{ // state 62
7,1103, // ID
15,1025, // `(
39,937, // <expr6>
41,1266, // <expr5>
44,772, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 63
0x80000000|1, // match move
0x80000000|990, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 64
0x80000000|1063, // match move
0x80000000|200, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 65
0x80000000|1, // match move
0x80000000|1005, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 66
2,11, // ws*
91,979, // ws
92,609, // " "
93,41, // {10}
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 67
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 68
0x80000000|101, // match move
0x80000000|813, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 69
0x80000000|1, // match move
0x80000000|854, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 70
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 71
0x80000000|1237, // match move
0x80000000|494, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 72
43,1055, // `<
45,663, // `>
46,133, // `<=
47,607, // `>=
48,185, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+32, // (default reduction)
  }
,
{ // state 73
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 74
38,333, // `&&
97,825, // "@"
MIN_REDUCTION+29, // (default reduction)
  }
,
{ // state 75
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 76
91,1287, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+138, // (default reduction)
  }
,
{ // state 77
2,344, // ws*
91,499, // ws
92,1310, // " "
93,1054, // {10}
MIN_REDUCTION+137, // (default reduction)
  }
,
{ // state 78
MIN_REDUCTION+14, // (default reduction)
  }
,
{ // state 79
0x80000000|898, // match move
0x80000000|476, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 80
0x80000000|1, // match move
0x80000000|1065, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 81
0x80000000|1, // match move
0x80000000|880, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 82
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 83
MIN_REDUCTION+64, // (default reduction)
  }
,
{ // state 84
0x80000000|1358, // match move
0x80000000|1000, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 85
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 86
52,675, // `*
54,345, // `/
55,493, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+43, // (default reduction)
  }
,
{ // state 87
22,MIN_REDUCTION+84, // `[
91,680, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+84, // "["
MIN_REDUCTION+84, // (default reduction)
  }
,
{ // state 88
0x80000000|1359, // match move
0x80000000|994, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 89
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 90
40,805, // `==
42,736, // `!=
97,666, // "@"
MIN_REDUCTION+31, // (default reduction)
  }
,
{ // state 91
0x80000000|511, // match move
0x80000000|792, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 92
2,1219, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 93
91,916, // ws
92,369, // " "
93,633, // {10}
MIN_REDUCTION+94, // (default reduction)
  }
,
{ // state 94
0x80000000|1301, // match move
0x80000000|906, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 95
MIN_REDUCTION+20, // (default reduction)
  }
,
{ // state 96
22,843, // `[
60,548, // `.
107,597, // "["
112,77, // "."
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 97
0x80000000|1, // match move
0x80000000|1117, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 98
7,1213, // ID
15,737, // `(
44,696, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 99
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 100
38,54, // `&&
97,825, // "@"
MIN_REDUCTION+29, // (default reduction)
  }
,
{ // state 101
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 102
7,1111, // ID
15,771, // `(
37,570, // <expr7>
39,103, // <expr6>
41,1372, // <expr5>
44,830, // <expr4>
49,801, // `+
50,723, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 103
40,776, // `==
42,754, // `!=
97,666, // "@"
MIN_REDUCTION+31, // (default reduction)
  }
,
{ // state 104
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 105
22,MIN_REDUCTION+56, // `[
107,MIN_REDUCTION+56, // "["
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 106
7,1115, // ID
15,774, // `(
37,572, // <expr7>
39,116, // <expr6>
41,1361, // <expr5>
44,836, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 107
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 108
0x80000000|828, // match move
0x80000000|612, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 109
0x80000000|1, // match move
0x80000000|1106, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 110
2,463, // ws*
22,MIN_REDUCTION+183, // `[
91,1201, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+183, // "["
MIN_REDUCTION+183, // (default reduction)
  }
,
{ // state 111
43,1038, // `<
45,443, // `>
46,98, // `<=
47,625, // `>=
48,12, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+34, // (default reduction)
  }
,
{ // state 112
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1190, // letter128
84,989, // {199..218 231..250}
85,989, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1189, // digit128
90,656, // {176..185}
116,421, // $$0
121,1318, // idChar
122,1272, // "_"
123,591, // idChar128
124,255, // {223}
  }
,
{ // state 113
91,1092, // ws
92,1225, // " "
93,1097, // {10}
MIN_REDUCTION+70, // (default reduction)
  }
,
{ // state 114
0x80000000|1, // match move
0x80000000|87, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 115
2,468, // ws*
22,MIN_REDUCTION+183, // `[
91,1200, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+183, // "["
MIN_REDUCTION+183, // (default reduction)
  }
,
{ // state 116
40,779, // `==
42,753, // `!=
97,666, // "@"
MIN_REDUCTION+31, // (default reduction)
  }
,
{ // state 117
7,1103, // ID
15,1025, // `(
37,195, // <expr7>
39,155, // <expr6>
41,1266, // <expr5>
44,772, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 118
91,383, // ws
92,556, // " "
93,53, // {10}
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 119
2,381, // ws*
91,249, // ws
92,782, // " "
93,319, // {10}
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 120
0x80000000|1198, // match move
0x80000000|1026, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 121
22,MIN_REDUCTION+177, // `[
107,MIN_REDUCTION+177, // "["
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 122
22,MIN_REDUCTION+177, // `[
107,MIN_REDUCTION+177, // "["
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 123
7,1111, // ID
15,771, // `(
31,944, // <expr>
35,1124, // <expr8>
37,100, // <expr7>
39,103, // <expr6>
41,1372, // <expr5>
44,830, // <expr4>
49,801, // `+
50,723, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 124
38,56, // `&&
97,825, // "@"
MIN_REDUCTION+29, // (default reduction)
  }
,
{ // state 125
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 126
91,144, // ws
92,1218, // " "
93,886, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 127
7,1115, // ID
15,774, // `(
44,758, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 128
2,900, // ws*
91,379, // ws
92,438, // " "
93,1099, // {10}
MIN_REDUCTION+83, // (default reduction)
  }
,
{ // state 129
22,MIN_REDUCTION+56, // `[
107,MIN_REDUCTION+56, // "["
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 130
7,1213, // ID
15,737, // `(
37,604, // <expr7>
39,90, // <expr6>
41,111, // <expr5>
44,947, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 131
76,818, // "u"
  }
,
{ // state 132
7,228, // ID
66,999, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,32, // letter128
84,1135, // {199..218 231..250}
85,1135, // {193..198 225..230}
  }
,
{ // state 133
7,1111, // ID
15,771, // `(
44,757, // <expr4>
49,801, // `+
50,723, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 134
22,MIN_REDUCTION+56, // `[
107,MIN_REDUCTION+56, // "["
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 135
91,559, // ws
92,751, // " "
93,878, // {10}
MIN_REDUCTION+126, // (default reduction)
  }
,
{ // state 136
72,1233, // "i"
  }
,
{ // state 137
22,MIN_REDUCTION+177, // `[
107,MIN_REDUCTION+177, // "["
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 138
2,500, // ws*
22,MIN_REDUCTION+183, // `[
91,1164, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+183, // "["
MIN_REDUCTION+183, // (default reduction)
  }
,
{ // state 139
-1, // $$start
-1, // <start>
-1, // ws*
-1, // <program>
-1, // <class decl>+
-1, // <class decl>
-1, // `class
1195, // ID
1204, // `{
-1, // <decl in class>*
1257, // `}
-1, // <decl in class>
-1, // <method decl>
-1, // `public
-1, // `void
774, // `(
-1, // `)
346, // <stmt>*
1367, // <type>
704, // `int
820, // `boolean
-1, // <empty bracket pair>
-1, // `[
-1, // `]
1162, // <stmt>
1001, // <assign>
-1, // `;
1152, // `break
543, // `++
1052, // `--
1242, // `if
425, // <expr>
-1, // `else
445, // <local var decl>
-1, // `=
1130, // <expr8>
-1, // `||
124, // <expr7>
-1, // `&&
116, // <expr6>
-1, // `==
1361, // <expr5>
-1, // `!=
-1, // `<
836, // <expr4>
-1, // `>
-1, // `<=
-1, // `>=
-1, // `instanceof
799, // `+
716, // <expr3>
248, // `-
-1, // `*
530, // <expr2>
-1, // `/
-1, // `%
840, // <cast expr>
658, // <expr1>
1231, // <unary expr>
161, // `!
-1, // `.
49, // INTLIT
65, // `true
747, // `false
1182, // `null
429, // `this
313, // letter
848, // "a"
848, // "p"
848, // "v"
848, // "c"
848, // "f"
848, // "i"
848, // "l"
848, // "o"
848, // "r"
848, // "u"
848, // "b"
848, // "e"
848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
848, // "h"
848, // "n"
848, // "t"
1185, // letter128
422, // {199..218 231..250}
422, // {193..198 225..230}
-1, // digit
380, // {"1".."9"}
504, // "0"
787, // digit128
631, // {176..185}
-1, // ws
-1, // " "
-1, // {10}
1068, // "#"
50, // "+"
1186, // "!"
331, // "@"
-1, // "%"
-1, // "&"
-1, // "*"
1067, // "("
-1, // ")"
527, // "{"
373, // "}"
205, // "-"
-1, // "="
-1, // "["
-1, // "]"
-1, // "|"
-1, // "<"
-1, // ">"
-1, // "."
-1, // ";"
-1, // "/"
-1, // idChar*
-1, // $$0
-1, // digit*
-1, // $$1
-1, // hexDigit*
-1, // $$2
-1, // idChar
-1, // "_"
-1, // idChar128
-1, // {223}
-1, // hexDigit
-1, // hexDigit128
-1, // $
-1, // $NT
  }
,
{ // state 140
0x80000000|1, // match move
0x80000000|1215, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 141
7,1103, // ID
15,1025, // `(
44,798, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 142
0x80000000|1, // match move
0x80000000|1023, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 143
0x80000000|186, // match move
0x80000000|5, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 144
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 145
7,1103, // ID
15,1025, // `(
44,1307, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 146
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 147
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 148
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 149
23,159, // `]
108,66, // "]"
  }
,
{ // state 150
91,75, // ws
92,1310, // " "
93,1054, // {10}
MIN_REDUCTION+140, // (default reduction)
  }
,
{ // state 151
2,1188, // ws*
91,993, // ws
92,991, // " "
93,1274, // {10}
MIN_REDUCTION+115, // (default reduction)
  }
,
{ // state 152
2,432, // ws*
22,MIN_REDUCTION+183, // `[
91,1140, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+183, // "["
MIN_REDUCTION+183, // (default reduction)
  }
,
{ // state 153
22,MIN_REDUCTION+56, // `[
107,MIN_REDUCTION+56, // "["
MIN_REDUCTION+56, // (default reduction)
  }
,
{ // state 154
0x80000000|1259, // match move
0x80000000|1029, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 155
40,791, // `==
42,790, // `!=
97,666, // "@"
MIN_REDUCTION+31, // (default reduction)
  }
,
{ // state 156
0x80000000|1, // match move
0x80000000|31, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 157
91,362, // ws
92,627, // " "
93,67, // {10}
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 158
0x80000000|1, // match move
0x80000000|37, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 159
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 160
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1226, // letter128
84,968, // {199..218 231..250}
85,968, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,284, // digit128
90,714, // {176..185}
116,426, // $$0
121,1318, // idChar
122,1272, // "_"
123,495, // idChar128
124,209, // {223}
  }
,
{ // state 161
7,1115, // ID
49,799, // `+
51,248, // `-
57,658, // <expr1>
58,985, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 162
7,1111, // ID
49,801, // `+
51,258, // `-
57,674, // <expr1>
58,972, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 163
22,921, // `[
60,225, // `.
107,597, // "["
112,77, // "."
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 164
22,917, // `[
60,227, // `.
107,597, // "["
112,77, // "."
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 165
2,167, // ws*
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 166
0x80000000|1234, // match move
0x80000000|563, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 167
0x80000000|1198, // match move
0x80000000|1141, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 168
7,444, // ID
66,999, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,32, // letter128
84,1135, // {199..218 231..250}
85,1135, // {193..198 225..230}
  }
,
{ // state 169
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 170
23,187, // `]
108,651, // "]"
  }
,
{ // state 171
22,MIN_REDUCTION+62, // `[
107,MIN_REDUCTION+62, // "["
MIN_REDUCTION+62, // (default reduction)
  }
,
{ // state 172
0x80000000|1, // match move
0x80000000|4, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 173
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 174
38,62, // `&&
97,825, // "@"
MIN_REDUCTION+29, // (default reduction)
  }
,
{ // state 175
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 176
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 177
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1170, // letter128
84,1009, // {199..218 231..250}
85,1009, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,270, // digit128
90,731, // {176..185}
116,440, // $$0
121,1318, // idChar
122,1272, // "_"
123,549, // idChar128
124,230, // {223}
  }
,
{ // state 178
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1168, // letter128
84,1006, // {199..218 231..250}
85,1006, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,273, // digit128
90,734, // {176..185}
116,441, // $$0
121,1318, // idChar
122,1272, // "_"
123,555, // idChar128
124,235, // {223}
  }
,
{ // state 179
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 180
23,190, // `]
108,646, // "]"
  }
,
{ // state 181
43,1055, // `<
45,663, // `>
46,133, // `<=
47,607, // `>=
48,185, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+33, // (default reduction)
  }
,
{ // state 182
-1, // $$start
-1, // <start>
-1, // ws*
-1, // <program>
-1, // <class decl>+
-1, // <class decl>
-1, // `class
1195, // ID
1204, // `{
-1, // <decl in class>*
1370, // `}
-1, // <decl in class>
-1, // <method decl>
-1, // `public
-1, // `void
774, // `(
-1, // `)
371, // <stmt>*
1367, // <type>
704, // `int
820, // `boolean
-1, // <empty bracket pair>
-1, // `[
-1, // `]
1162, // <stmt>
1001, // <assign>
-1, // `;
1152, // `break
543, // `++
1052, // `--
1242, // `if
425, // <expr>
-1, // `else
445, // <local var decl>
-1, // `=
1130, // <expr8>
-1, // `||
124, // <expr7>
-1, // `&&
116, // <expr6>
-1, // `==
1361, // <expr5>
-1, // `!=
-1, // `<
836, // <expr4>
-1, // `>
-1, // `<=
-1, // `>=
-1, // `instanceof
799, // `+
716, // <expr3>
248, // `-
-1, // `*
530, // <expr2>
-1, // `/
-1, // `%
840, // <cast expr>
658, // <expr1>
1231, // <unary expr>
161, // `!
-1, // `.
49, // INTLIT
65, // `true
747, // `false
1182, // `null
429, // `this
313, // letter
848, // "a"
848, // "p"
848, // "v"
848, // "c"
848, // "f"
848, // "i"
848, // "l"
848, // "o"
848, // "r"
848, // "u"
848, // "b"
848, // "e"
848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
848, // "h"
848, // "n"
848, // "t"
1185, // letter128
422, // {199..218 231..250}
422, // {193..198 225..230}
-1, // digit
380, // {"1".."9"}
504, // "0"
787, // digit128
631, // {176..185}
-1, // ws
-1, // " "
-1, // {10}
1068, // "#"
50, // "+"
1186, // "!"
331, // "@"
-1, // "%"
-1, // "&"
-1, // "*"
1067, // "("
-1, // ")"
527, // "{"
339, // "}"
205, // "-"
-1, // "="
-1, // "["
-1, // "]"
-1, // "|"
-1, // "<"
-1, // ">"
-1, // "."
-1, // ";"
-1, // "/"
-1, // idChar*
-1, // $$0
-1, // digit*
-1, // $$1
-1, // hexDigit*
-1, // $$2
-1, // idChar
-1, // "_"
-1, // idChar128
-1, // {223}
-1, // hexDigit
-1, // hexDigit128
-1, // $
-1, // $NT
  }
,
{ // state 183
7,208, // ID
18,553, // <type>
19,551, // `int
20,478, // `boolean
66,466, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,518, // letter128
84,1009, // {199..218 231..250}
85,1009, // {193..198 225..230}
94,667, // "#"
  }
,
{ // state 184
2,113, // ws*
91,1323, // ws
92,1225, // " "
93,1097, // {10}
MIN_REDUCTION+71, // (default reduction)
  }
,
{ // state 185
7,214, // ID
18,534, // <type>
19,554, // `int
20,471, // `boolean
66,470, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,522, // letter128
84,1006, // {199..218 231..250}
85,1006, // {193..198 225..230}
94,662, // "#"
  }
,
{ // state 186
MIN_REDUCTION+140, // (default reduction)
  }
,
{ // state 187
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 188
7,1213, // ID
49,770, // `+
51,216, // `-
57,442, // <expr1>
58,943, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 189
23,349, // `]
108,1094, // "]"
  }
,
{ // state 190
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 191
2,76, // ws*
91,1292, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+139, // (default reduction)
  }
,
{ // state 192
91,372, // ws
92,620, // " "
93,73, // {10}
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 193
43,1056, // `<
45,659, // `>
46,127, // `<=
47,608, // `>=
48,183, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+33, // (default reduction)
  }
,
{ // state 194
7,392, // ID
18,206, // <type>
19,538, // `int
20,484, // `boolean
66,458, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,411, // letter128
84,968, // {199..218 231..250}
85,968, // {193..198 225..230}
94,21, // "#"
  }
,
{ // state 195
38,62, // `&&
97,825, // "@"
MIN_REDUCTION+28, // (default reduction)
  }
,
{ // state 196
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 197
91,75, // ws
92,1310, // " "
93,1054, // {10}
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 198
7,1020, // ID
8,481, // `{
15,774, // `(
18,1367, // <type>
19,704, // `int
20,820, // `boolean
24,1300, // <stmt>
25,1095, // <assign>
27,515, // `break
28,1207, // `++
29,544, // `--
30,940, // `if
31,425, // <expr>
33,23, // <local var decl>
35,1130, // <expr8>
37,124, // <expr7>
39,116, // <expr6>
41,1361, // <expr5>
44,836, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,313, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1185, // letter128
84,422, // {199..218 231..250}
85,422, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,1068, // "#"
95,50, // "+"
96,1186, // "!"
97,331, // "@"
101,1067, // "("
103,527, // "{"
105,205, // "-"
  }
,
{ // state 199
0x80000000|271, // match move
0x80000000|110, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 200
22,MIN_REDUCTION+159, // `[
107,MIN_REDUCTION+159, // "["
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 201
MIN_REDUCTION+19, // (default reduction)
  }
,
{ // state 202
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 203
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 204
2,978, // ws*
22,MIN_REDUCTION+153, // `[
91,1201, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+153, // "["
MIN_REDUCTION+153, // (default reduction)
  }
,
{ // state 205
2,1383, // ws*
91,1100, // ws
92,82, // " "
93,179, // {10}
MIN_REDUCTION+115, // (default reduction)
  }
,
{ // state 206
21,1313, // <empty bracket pair>
22,234, // `[
107,1202, // "["
MIN_REDUCTION+39, // (default reduction)
  }
,
{ // state 207
2,970, // ws*
22,MIN_REDUCTION+153, // `[
91,1200, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+153, // "["
MIN_REDUCTION+153, // (default reduction)
  }
,
{ // state 208
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 209
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 210
0x80000000|265, // match move
0x80000000|115, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 211
22,MIN_REDUCTION+62, // `[
107,MIN_REDUCTION+62, // "["
MIN_REDUCTION+62, // (default reduction)
  }
,
{ // state 212
91,335, // ws
92,609, // " "
93,41, // {10}
MIN_REDUCTION+76, // (default reduction)
  }
,
{ // state 213
7,401, // ID
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
  }
,
{ // state 214
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 215
0x80000000|884, // match move
0x80000000|715, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 216
7,1213, // ID
49,770, // `+
51,216, // `-
57,442, // <expr1>
58,781, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 217
22,MIN_REDUCTION+62, // `[
107,MIN_REDUCTION+62, // "["
MIN_REDUCTION+62, // (default reduction)
  }
,
{ // state 218
2,528, // ws*
  }
,
{ // state 219
2,295, // ws*
91,1323, // ws
92,1225, // " "
93,1097, // {10}
MIN_REDUCTION+77, // (default reduction)
  }
,
{ // state 220
0x80000000|1, // match move
0x80000000|995, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 221
0x80000000|1087, // match move
0x80000000|598, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 222
49,845, // `+
51,911, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+35, // (default reduction)
  }
,
{ // state 223
22,MIN_REDUCTION+180, // `[
91,708, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+180, // "["
MIN_REDUCTION+180, // (default reduction)
  }
,
{ // state 224
70,596, // "c"
  }
,
{ // state 225
7,416, // ID
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
  }
,
{ // state 226
22,MIN_REDUCTION+180, // `[
91,701, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+180, // "["
MIN_REDUCTION+180, // (default reduction)
  }
,
{ // state 227
7,412, // ID
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
  }
,
{ // state 228
0x80000000|889, // match move
0x80000000|355, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 229
22,921, // `[
60,225, // `.
107,597, // "["
112,77, // "."
MIN_REDUCTION+50, // (default reduction)
  }
,
{ // state 230
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 231
0x80000000|883, // match move
0x80000000|712, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 232
22,917, // `[
60,227, // `.
107,597, // "["
112,77, // "."
MIN_REDUCTION+50, // (default reduction)
  }
,
{ // state 233
22,885, // `[
60,213, // `.
107,597, // "["
112,77, // "."
MIN_REDUCTION+55, // (default reduction)
  }
,
{ // state 234
23,99, // `]
108,697, // "]"
  }
,
{ // state 235
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 236
MIN_REDUCTION+22, // (default reduction)
  }
,
{ // state 237
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1128, // letter128
84,1071, // {199..218 231..250}
85,1071, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1264, // digit128
90,998, // {176..185}
115,306, // idChar*
116,1014, // $$0
121,301, // idChar
122,1272, // "_"
123,524, // idChar128
124,922, // {223}
  }
,
{ // state 238
49,807, // `+
51,895, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+35, // (default reduction)
  }
,
{ // state 239
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 240
0x80000000|300, // match move
0x80000000|138, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 241
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 242
86,639, // digit
87,1153, // {"1".."9"}
88,1153, // "0"
89,360, // digit128
90,710, // {176..185}
117,941, // digit*
118,358, // $$1
  }
,
{ // state 243
2,957, // ws*
22,MIN_REDUCTION+153, // `[
91,1164, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+153, // "["
MIN_REDUCTION+153, // (default reduction)
  }
,
{ // state 244
7,1103, // ID
49,745, // `+
51,244, // `-
57,711, // <expr1>
58,873, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 245
2,477, // ws*
  }
,
{ // state 246
0x80000000|537, // match move
0x80000000|1235, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 247
22,MIN_REDUCTION+62, // `[
107,MIN_REDUCTION+62, // "["
MIN_REDUCTION+62, // (default reduction)
  }
,
{ // state 248
7,1115, // ID
49,799, // `+
51,248, // `-
57,658, // <expr1>
58,858, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 249
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 250
2,490, // ws*
  }
,
{ // state 251
22,MIN_REDUCTION+180, // `[
91,722, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+180, // "["
MIN_REDUCTION+180, // (default reduction)
  }
,
{ // state 252
2,487, // ws*
  }
,
{ // state 253
0x80000000|967, // match move
0x80000000|1149, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 254
7,1020, // ID
8,481, // `{
15,774, // `(
18,1367, // <type>
19,704, // `int
20,820, // `boolean
24,1203, // <stmt>
25,1095, // <assign>
27,515, // `break
28,1207, // `++
29,544, // `--
30,940, // `if
31,425, // <expr>
33,23, // <local var decl>
35,1130, // <expr8>
37,124, // <expr7>
39,116, // <expr6>
41,1361, // <expr5>
44,836, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,313, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1185, // letter128
84,422, // {199..218 231..250}
85,422, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,1068, // "#"
95,50, // "+"
96,1186, // "!"
97,331, // "@"
101,1067, // "("
103,527, // "{"
105,205, // "-"
  }
,
{ // state 255
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 256
22,MIN_REDUCTION+159, // `[
107,MIN_REDUCTION+159, // "["
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 257
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 258
7,1111, // ID
49,801, // `+
51,258, // `-
57,674, // <expr1>
58,856, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 259
22,MIN_REDUCTION+159, // `[
107,MIN_REDUCTION+159, // "["
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 260
2,859, // ws*
22,MIN_REDUCTION+153, // `[
91,1140, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+153, // "["
MIN_REDUCTION+153, // (default reduction)
  }
,
{ // state 261
MIN_REDUCTION+6, // (default reduction)
  }
,
{ // state 262
0x80000000|1, // match move
0x80000000|558, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 263
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,64, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,919, // digit128
90,673, // {176..185}
115,1171, // idChar*
116,1375, // $$0
121,301, // idChar
122,1272, // "_"
123,57, // idChar128
124,531, // {223}
  }
,
{ // state 264
2,480, // ws*
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 265
2,468, // ws*
  }
,
{ // state 266
32,955, // `else
94,599, // "#"
  }
,
{ // state 267
15,803, // `(
101,469, // "("
  }
,
{ // state 268
MIN_REDUCTION+175, // (default reduction)
  }
,
{ // state 269
MIN_REDUCTION+45, // (default reduction)
  }
,
{ // state 270
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 271
2,463, // ws*
  }
,
{ // state 272
MIN_REDUCTION+45, // (default reduction)
  }
,
{ // state 273
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 274
MIN_REDUCTION+45, // (default reduction)
  }
,
{ // state 275
0x80000000|1, // match move
0x80000000|695, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 276
67,1126, // "a"
68,1126, // "p"
69,1126, // "v"
70,1126, // "c"
71,1126, // "f"
72,1126, // "i"
73,1126, // "l"
74,1126, // "o"
75,1126, // "r"
76,1126, // "u"
77,1126, // "b"
78,1126, // "e"
79,1126, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,1126, // "h"
81,1126, // "n"
82,1126, // "t"
85,15, // {193..198 225..230}
87,1126, // {"1".."9"}
88,1126, // "0"
90,15, // {176..185}
119,833, // hexDigit*
120,109, // $$2
125,1245, // hexDigit
126,210, // hexDigit128
  }
,
{ // state 277
0x80000000|1, // match move
0x80000000|1016, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 278
0x80000000|1, // match move
0x80000000|578, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 279
0x80000000|1, // match move
0x80000000|577, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 280
91,148, // ws
92,1047, // " "
93,821, // {10}
MIN_REDUCTION+120, // (default reduction)
  }
,
{ // state 281
0x80000000|1, // match move
0x80000000|1015, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 282
0x80000000|1, // match move
0x80000000|1088, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 283
0x80000000|1, // match move
0x80000000|984, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 284
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 285
91,169, // ws
92,1074, // " "
93,1290, // {10}
MIN_REDUCTION+134, // (default reduction)
  }
,
{ // state 286
22,885, // `[
60,213, // `.
107,597, // "["
112,77, // "."
MIN_REDUCTION+50, // (default reduction)
  }
,
{ // state 287
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,28, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,827, // digit128
90,629, // {176..185}
115,1194, // idChar*
116,1329, // $$0
121,301, // idChar
122,1272, // "_"
123,88, // idChar128
124,541, // {223}
  }
,
{ // state 288
2,982, // ws*
MIN_REDUCTION+139, // (default reduction)
  }
,
{ // state 289
MIN_REDUCTION+24, // (default reduction)
  }
,
{ // state 290
MIN_REDUCTION+14, // (default reduction)
  }
,
{ // state 291
2,167, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 292
52,655, // `*
54,312, // `/
55,615, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+41, // (default reduction)
  }
,
{ // state 293
49,844, // `+
51,914, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+35, // (default reduction)
  }
,
{ // state 294
43,1073, // `<
45,649, // `>
46,141, // `<=
47,145, // `>=
48,194, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+33, // (default reduction)
  }
,
{ // state 295
91,1092, // ws
92,1225, // " "
93,1097, // {10}
MIN_REDUCTION+76, // (default reduction)
  }
,
{ // state 296
96,1143, // "!"
99,1004, // "&"
106,942, // "="
109,676, // "|"
110,40, // "<"
111,1388, // ">"
  }
,
{ // state 297
67,1126, // "a"
68,1126, // "p"
69,1126, // "v"
70,1126, // "c"
71,1126, // "f"
72,1126, // "i"
73,1126, // "l"
74,1126, // "o"
75,1126, // "r"
76,1126, // "u"
77,1126, // "b"
78,1126, // "e"
79,1126, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,1126, // "h"
81,1126, // "n"
82,1126, // "t"
85,22, // {193..198 225..230}
87,1126, // {"1".."9"}
88,1126, // "0"
90,22, // {176..185}
119,869, // hexDigit*
120,140, // $$2
125,1245, // hexDigit
126,240, // hexDigit128
  }
,
{ // state 298
0x80000000|879, // match move
0x80000000|630, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 299
22,MIN_REDUCTION+177, // `[
107,MIN_REDUCTION+177, // "["
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 300
2,500, // ws*
  }
,
{ // state 301
MIN_REDUCTION+173, // (default reduction)
  }
,
{ // state 302
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 303
74,184, // "o"
  }
,
{ // state 304
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,29, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,823, // digit128
90,631, // {176..185}
115,1196, // idChar*
116,1326, // $$0
121,301, // idChar
122,1272, // "_"
123,84, // idChar128
124,535, // {223}
  }
,
{ // state 305
MIN_REDUCTION+66, // (default reduction)
  }
,
{ // state 306
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1128, // letter128
84,1071, // {199..218 231..250}
85,1071, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1264, // digit128
90,998, // {176..185}
116,691, // $$0
121,1318, // idChar
122,1272, // "_"
123,524, // idChar128
124,922, // {223}
  }
,
{ // state 307
2,1139, // ws*
91,993, // ws
92,991, // " "
93,1274, // {10}
MIN_REDUCTION+117, // (default reduction)
  }
,
{ // state 308
22,MIN_REDUCTION+65, // `[
107,MIN_REDUCTION+65, // "["
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 309
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 310
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 311
91,516, // ws
92,1030, // " "
93,1322, // {10}
128,MIN_REDUCTION+80, // $NT
  }
,
{ // state 312
7,1103, // ID
15,1025, // `(
49,745, // `+
51,244, // `-
53,274, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 313
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,475, // letter128
84,422, // {199..218 231..250}
85,422, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,841, // digit128
90,766, // {176..185}
115,1187, // idChar*
116,505, // $$0
121,301, // idChar
122,1272, // "_"
123,71, // idChar128
124,839, // {223}
  }
,
{ // state 314
22,MIN_REDUCTION+63, // `[
107,MIN_REDUCTION+63, // "["
MIN_REDUCTION+63, // (default reduction)
  }
,
{ // state 315
0x80000000|1, // match move
0x80000000|406, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 316
0x80000000|1, // match move
0x80000000|402, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 317
2,498, // ws*
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 318
0x80000000|1, // match move
0x80000000|1355, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 319
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 320
0x80000000|1, // match move
0x80000000|1064, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 321
7,1111, // ID
15,771, // `(
49,801, // `+
51,258, // `-
53,272, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
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
{ // state 322
7,1115, // ID
15,774, // `(
49,799, // `+
51,248, // `-
53,269, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 323
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 324
52,642, // `*
54,321, // `/
55,619, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+41, // (default reduction)
  }
,
{ // state 325
-1, // $$start
-1, // <start>
-1, // ws*
-1, // <program>
-1, // <class decl>+
-1, // <class decl>
-1, // `class
1195, // ID
1204, // `{
-1, // <decl in class>*
1223, // `}
-1, // <decl in class>
-1, // <method decl>
-1, // `public
-1, // `void
774, // `(
-1, // `)
-1, // <stmt>*
1367, // <type>
704, // `int
820, // `boolean
-1, // <empty bracket pair>
-1, // `[
-1, // `]
877, // <stmt>
1001, // <assign>
-1, // `;
1152, // `break
543, // `++
1052, // `--
1242, // `if
425, // <expr>
-1, // `else
445, // <local var decl>
-1, // `=
1130, // <expr8>
-1, // `||
124, // <expr7>
-1, // `&&
116, // <expr6>
-1, // `==
1361, // <expr5>
-1, // `!=
-1, // `<
836, // <expr4>
-1, // `>
-1, // `<=
-1, // `>=
-1, // `instanceof
799, // `+
716, // <expr3>
248, // `-
-1, // `*
530, // <expr2>
-1, // `/
-1, // `%
840, // <cast expr>
658, // <expr1>
1231, // <unary expr>
161, // `!
-1, // `.
49, // INTLIT
65, // `true
747, // `false
1182, // `null
429, // `this
313, // letter
848, // "a"
848, // "p"
848, // "v"
848, // "c"
848, // "f"
848, // "i"
848, // "l"
848, // "o"
848, // "r"
848, // "u"
848, // "b"
848, // "e"
848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
848, // "h"
848, // "n"
848, // "t"
1185, // letter128
422, // {199..218 231..250}
422, // {193..198 225..230}
-1, // digit
380, // {"1".."9"}
504, // "0"
787, // digit128
631, // {176..185}
-1, // ws
-1, // " "
-1, // {10}
1068, // "#"
50, // "+"
1186, // "!"
331, // "@"
-1, // "%"
-1, // "&"
-1, // "*"
1067, // "("
-1, // ")"
527, // "{"
1049, // "}"
205, // "-"
-1, // "="
-1, // "["
-1, // "]"
-1, // "|"
-1, // "<"
-1, // ">"
-1, // "."
-1, // ";"
-1, // "/"
-1, // idChar*
-1, // $$0
-1, // digit*
-1, // $$1
-1, // hexDigit*
-1, // $$2
-1, // idChar
-1, // "_"
-1, // idChar128
-1, // {223}
-1, // hexDigit
-1, // hexDigit128
-1, // $
-1, // $NT
  }
,
{ // state 326
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 327
43,1073, // `<
45,649, // `>
46,141, // `<=
47,145, // `>=
48,194, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+32, // (default reduction)
  }
,
{ // state 328
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 329
MIN_REDUCTION+157, // (default reduction)
  }
,
{ // state 330
0x80000000|1254, // match move
0x80000000|1041, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 331
95,952, // "+"
105,926, // "-"
  }
,
{ // state 332
2,432, // ws*
  }
,
{ // state 333
7,1213, // ID
15,737, // `(
39,1060, // <expr6>
41,111, // <expr5>
44,947, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 334
22,MIN_REDUCTION+63, // `[
107,MIN_REDUCTION+63, // "["
MIN_REDUCTION+63, // (default reduction)
  }
,
{ // state 335
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 336
22,MIN_REDUCTION+63, // `[
107,MIN_REDUCTION+63, // "["
MIN_REDUCTION+63, // (default reduction)
  }
,
{ // state 337
MIN_REDUCTION+18, // (default reduction)
  }
,
{ // state 338
7,956, // ID
8,182, // `{
15,774, // `(
18,1367, // <type>
19,704, // `int
20,820, // `boolean
24,1300, // <stmt>
25,973, // <assign>
27,1154, // `break
28,168, // `++
29,132, // `--
30,832, // `if
31,425, // <expr>
33,796, // <local var decl>
35,1130, // <expr8>
37,124, // <expr7>
39,116, // <expr6>
41,1361, // <expr5>
44,836, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,313, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1185, // letter128
84,422, // {199..218 231..250}
85,422, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,1068, // "#"
95,50, // "+"
96,1186, // "!"
97,331, // "@"
101,1067, // "("
103,527, // "{"
105,205, // "-"
  }
,
{ // state 339
0x80000000|1133, // match move
0x80000000|1109, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 340
0x80000000|1, // match move
0x80000000|592, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 341
0x80000000|1051, // match move
0x80000000|1002, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 342
52,643, // `*
54,322, // `/
55,628, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+41, // (default reduction)
  }
,
{ // state 343
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,6, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,851, // digit128
90,710, // {176..185}
115,1132, // idChar*
116,1345, // $$0
121,301, // idChar
122,1272, // "_"
123,330, // idChar128
124,398, // {223}
  }
,
{ // state 344
91,75, // ws
92,1310, // " "
93,1054, // {10}
MIN_REDUCTION+136, // (default reduction)
  }
,
{ // state 345
7,1213, // ID
15,737, // `(
49,770, // `+
51,216, // `-
53,502, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 346
-1, // $$start
-1, // <start>
-1, // ws*
-1, // <program>
-1, // <class decl>+
-1, // <class decl>
-1, // `class
1195, // ID
1204, // `{
-1, // <decl in class>*
767, // `}
-1, // <decl in class>
-1, // <method decl>
-1, // `public
-1, // `void
774, // `(
-1, // `)
-1, // <stmt>*
1367, // <type>
704, // `int
820, // `boolean
-1, // <empty bracket pair>
-1, // `[
-1, // `]
877, // <stmt>
1001, // <assign>
-1, // `;
1152, // `break
543, // `++
1052, // `--
1242, // `if
425, // <expr>
-1, // `else
445, // <local var decl>
-1, // `=
1130, // <expr8>
-1, // `||
124, // <expr7>
-1, // `&&
116, // <expr6>
-1, // `==
1361, // <expr5>
-1, // `!=
-1, // `<
836, // <expr4>
-1, // `>
-1, // `<=
-1, // `>=
-1, // `instanceof
799, // `+
716, // <expr3>
248, // `-
-1, // `*
530, // <expr2>
-1, // `/
-1, // `%
840, // <cast expr>
658, // <expr1>
1231, // <unary expr>
161, // `!
-1, // `.
49, // INTLIT
65, // `true
747, // `false
1182, // `null
429, // `this
313, // letter
848, // "a"
848, // "p"
848, // "v"
848, // "c"
848, // "f"
848, // "i"
848, // "l"
848, // "o"
848, // "r"
848, // "u"
848, // "b"
848, // "e"
848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
848, // "h"
848, // "n"
848, // "t"
1185, // letter128
422, // {199..218 231..250}
422, // {193..198 225..230}
-1, // digit
380, // {"1".."9"}
504, // "0"
787, // digit128
631, // {176..185}
-1, // ws
-1, // " "
-1, // {10}
1068, // "#"
50, // "+"
1186, // "!"
331, // "@"
-1, // "%"
-1, // "&"
-1, // "*"
1067, // "("
-1, // ")"
527, // "{"
373, // "}"
205, // "-"
-1, // "="
-1, // "["
-1, // "]"
-1, // "|"
-1, // "<"
-1, // ">"
-1, // "."
-1, // ";"
-1, // "/"
-1, // idChar*
-1, // $$0
-1, // digit*
-1, // $$1
-1, // hexDigit*
-1, // $$2
-1, // idChar
-1, // "_"
-1, // idChar128
-1, // {223}
-1, // hexDigit
-1, // hexDigit128
-1, // $
-1, // $NT
  }
,
{ // state 347
71,870, // "f"
81,1032, // "n"
82,1376, // "t"
  }
,
{ // state 348
0x80000000|332, // match move
0x80000000|152, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 349
0x80000000|1, // match move
0x80000000|1142, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 350
86,639, // digit
87,1153, // {"1".."9"}
88,1153, // "0"
89,298, // digit128
90,673, // {176..185}
117,888, // digit*
118,220, // $$1
  }
,
{ // state 351
22,MIN_REDUCTION+63, // `[
107,MIN_REDUCTION+63, // "["
MIN_REDUCTION+63, // (default reduction)
  }
,
{ // state 352
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 353
91,125, // ws
92,1011, // " "
93,1258, // {10}
MIN_REDUCTION+144, // (default reduction)
  }
,
{ // state 354
95,1205, // "+"
96,1143, // "!"
99,1004, // "&"
105,864, // "-"
106,942, // "="
109,676, // "|"
110,40, // "<"
111,1388, // ">"
  }
,
{ // state 355
MIN_REDUCTION+19, // (default reduction)
  }
,
{ // state 356
7,MIN_REDUCTION+11, // ID
22,MIN_REDUCTION+57, // `[
28,1352, // `++
29,1172, // `--
67,MIN_REDUCTION+11, // "a"
68,MIN_REDUCTION+11, // "p"
69,MIN_REDUCTION+11, // "v"
70,MIN_REDUCTION+11, // "c"
71,MIN_REDUCTION+11, // "f"
72,MIN_REDUCTION+11, // "i"
73,MIN_REDUCTION+11, // "l"
74,MIN_REDUCTION+11, // "o"
75,MIN_REDUCTION+11, // "r"
76,MIN_REDUCTION+11, // "u"
77,MIN_REDUCTION+11, // "b"
78,MIN_REDUCTION+11, // "e"
79,MIN_REDUCTION+11, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,MIN_REDUCTION+11, // "h"
81,MIN_REDUCTION+11, // "n"
82,MIN_REDUCTION+11, // "t"
84,MIN_REDUCTION+11, // {199..218 231..250}
85,MIN_REDUCTION+11, // {193..198 225..230}
97,354, // "@"
107,MIN_REDUCTION+57, // "["
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 357
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 358
0x80000000|1, // match move
0x80000000|1050, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 359
22,MIN_REDUCTION+65, // `[
107,MIN_REDUCTION+65, // "["
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 360
0x80000000|861, // match move
0x80000000|756, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 361
71,826, // "f"
81,1042, // "n"
82,1392, // "t"
  }
,
{ // state 362
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 363
0x80000000|988, // match move
0x80000000|741, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 364
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+140, // (default reduction)
  }
,
{ // state 365
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 366
2,MIN_REDUCTION+65, // ws*
92,MIN_REDUCTION+65, // " "
93,MIN_REDUCTION+65, // {10}
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 367
22,MIN_REDUCTION+180, // `[
91,680, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+180, // "["
MIN_REDUCTION+180, // (default reduction)
  }
,
{ // state 368
0x80000000|908, // match move
0x80000000|539, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 369
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 370
22,MIN_REDUCTION+159, // `[
107,MIN_REDUCTION+159, // "["
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 371
-1, // $$start
-1, // <start>
-1, // ws*
-1, // <program>
-1, // <class decl>+
-1, // <class decl>
-1, // `class
1195, // ID
1204, // `{
-1, // <decl in class>*
1223, // `}
-1, // <decl in class>
-1, // <method decl>
-1, // `public
-1, // `void
774, // `(
-1, // `)
-1, // <stmt>*
1367, // <type>
704, // `int
820, // `boolean
-1, // <empty bracket pair>
-1, // `[
-1, // `]
877, // <stmt>
1001, // <assign>
-1, // `;
1152, // `break
543, // `++
1052, // `--
1242, // `if
425, // <expr>
-1, // `else
445, // <local var decl>
-1, // `=
1130, // <expr8>
-1, // `||
124, // <expr7>
-1, // `&&
116, // <expr6>
-1, // `==
1361, // <expr5>
-1, // `!=
-1, // `<
836, // <expr4>
-1, // `>
-1, // `<=
-1, // `>=
-1, // `instanceof
799, // `+
716, // <expr3>
248, // `-
-1, // `*
530, // <expr2>
-1, // `/
-1, // `%
840, // <cast expr>
658, // <expr1>
1231, // <unary expr>
161, // `!
-1, // `.
49, // INTLIT
65, // `true
747, // `false
1182, // `null
429, // `this
313, // letter
848, // "a"
848, // "p"
848, // "v"
848, // "c"
848, // "f"
848, // "i"
848, // "l"
848, // "o"
848, // "r"
848, // "u"
848, // "b"
848, // "e"
848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
848, // "h"
848, // "n"
848, // "t"
1185, // letter128
422, // {199..218 231..250}
422, // {193..198 225..230}
-1, // digit
380, // {"1".."9"}
504, // "0"
787, // digit128
631, // {176..185}
-1, // ws
-1, // " "
-1, // {10}
1068, // "#"
50, // "+"
1186, // "!"
331, // "@"
-1, // "%"
-1, // "&"
-1, // "*"
1067, // "("
-1, // ")"
527, // "{"
339, // "}"
205, // "-"
-1, // "="
-1, // "["
-1, // "]"
-1, // "|"
-1, // "<"
-1, // ">"
-1, // "."
-1, // ";"
-1, // "/"
-1, // idChar*
-1, // $$0
-1, // digit*
-1, // $$1
-1, // hexDigit*
-1, // $$2
-1, // idChar
-1, // "_"
-1, // idChar128
-1, // {223}
-1, // hexDigit
-1, // hexDigit128
-1, // $
-1, // $NT
  }
,
{ // state 372
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 373
2,853, // ws*
91,357, // ws
92,1304, // " "
93,1012, // {10}
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 374
0x80000000|1, // match move
0x80000000|1314, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 375
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 376
22,MIN_REDUCTION+65, // `[
107,MIN_REDUCTION+65, // "["
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 377
0x80000000|1, // match move
0x80000000|1324, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 378
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 379
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 380
86,639, // digit
87,1153, // {"1".."9"}
88,1153, // "0"
89,215, // digit128
90,631, // {176..185}
117,953, // digit*
118,385, // $$1
  }
,
{ // state 381
91,1069, // ws
92,782, // " "
93,319, // {10}
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 382
2,859, // ws*
  }
,
{ // state 383
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 384
0x80000000|1, // match move
0x80000000|1022, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 385
0x80000000|1, // match move
0x80000000|1027, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 386
86,639, // digit
87,1153, // {"1".."9"}
88,1153, // "0"
89,231, // digit128
90,629, // {176..185}
117,950, // digit*
118,384, // $$1
  }
,
{ // state 387
0x80000000|1, // match move
0x80000000|105, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 388
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 389
0x80000000|1075, // match move
0x80000000|1046, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 390
0x80000000|1077, // match move
0x80000000|1044, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 391
0x80000000|1, // match move
0x80000000|423, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 392
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 393
22,MIN_REDUCTION+65, // `[
107,MIN_REDUCTION+65, // "["
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 394
91,1048, // ws
92,147, // " "
93,43, // {10}
MIN_REDUCTION+106, // (default reduction)
  }
,
{ // state 395
MIN_REDUCTION+167, // (default reduction)
  }
,
{ // state 396
76,784, // "u"
  }
,
{ // state 397
91,614, // ws
92,424, // " "
93,1108, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 398
0x80000000|1070, // match move
0x80000000|974, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 399
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 400
0x80000000|1, // match move
0x80000000|367, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 401
0x80000000|1, // match move
0x80000000|153, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 402
22,MIN_REDUCTION+90, // `[
91,708, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+90, // "["
MIN_REDUCTION+90, // (default reduction)
  }
,
{ // state 403
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 404
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 405
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 406
22,MIN_REDUCTION+90, // `[
91,701, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+90, // "["
MIN_REDUCTION+90, // (default reduction)
  }
,
{ // state 407
91,1287, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 408
2,978, // ws*
  }
,
{ // state 409
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 410
2,970, // ws*
  }
,
{ // state 411
2,936, // ws*
91,954, // ws
92,556, // " "
93,53, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 412
0x80000000|1, // match move
0x80000000|129, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 413
52,643, // `*
54,322, // `/
55,628, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+42, // (default reduction)
  }
,
{ // state 414
MIN_REDUCTION+166, // (default reduction)
  }
,
{ // state 415
95,777, // "+"
96,1143, // "!"
99,1004, // "&"
105,867, // "-"
106,942, // "="
109,676, // "|"
110,40, // "<"
111,1388, // ">"
  }
,
{ // state 416
0x80000000|1, // match move
0x80000000|134, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 417
16,1247, // `)
21,46, // <empty bracket pair>
22,1391, // `[
102,1090, // ")"
107,1202, // "["
  }
,
{ // state 418
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,70, // letter128
84,1157, // {199..218 231..250}
85,1157, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1390, // digit128
90,323, // {176..185}
116,309, // $$0
121,1318, // idChar
122,1272, // "_"
123,545, // idChar128
124,404, // {223}
  }
,
{ // state 419
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 420
0x80000000|1, // match move
0x80000000|351, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 421
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 422
0x80000000|1091, // match move
0x80000000|739, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 423
22,MIN_REDUCTION+90, // `[
91,722, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+90, // "["
MIN_REDUCTION+90, // (default reduction)
  }
,
{ // state 424
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 425
34,934, // `=
106,866, // "="
  }
,
{ // state 426
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 427
32,338, // `else
94,599, // "#"
  }
,
{ // state 428
0x80000000|1, // match move
0x80000000|336, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 429
0x80000000|1, // match move
0x80000000|334, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 430
0x80000000|1357, // match move
0x80000000|13, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 431
0x80000000|1385, // match move
0x80000000|1021, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 432
0x80000000|1, // match move
0x80000000|1288, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 433
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 434
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1190, // letter128
84,989, // {199..218 231..250}
85,989, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1189, // digit128
90,656, // {176..185}
115,112, // idChar*
116,175, // $$0
121,301, // idChar
122,1272, // "_"
123,591, // idChar128
124,255, // {223}
  }
,
{ // state 435
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 436
91,565, // ws
92,405, // " "
93,1110, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 437
2,957, // ws*
  }
,
{ // state 438
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 439
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,221, // letter128
84,1135, // {199..218 231..250}
85,1135, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1236, // digit128
90,452, // {176..185}
115,769, // idChar*
116,456, // $$0
121,301, // idChar
122,1272, // "_"
123,865, // idChar128
124,368, // {223}
  }
,
{ // state 440
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 441
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 442
0x80000000|1, // match move
0x80000000|96, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 443
7,1213, // ID
15,737, // `(
44,1177, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 444
0x80000000|337, // match move
0x80000000|1380, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 445
26,289, // `;
113,191, // ";"
  }
,
{ // state 446
2,212, // ws*
91,979, // ws
92,609, // " "
93,41, // {10}
MIN_REDUCTION+77, // (default reduction)
  }
,
{ // state 447
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 448
0x80000000|1, // match move
0x80000000|226, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 449
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 450
0x80000000|1, // match move
0x80000000|223, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 451
7,MIN_REDUCTION+11, // ID
22,MIN_REDUCTION+57, // `[
28,1352, // `++
29,1172, // `--
67,MIN_REDUCTION+11, // "a"
68,MIN_REDUCTION+11, // "p"
69,MIN_REDUCTION+11, // "v"
70,MIN_REDUCTION+11, // "c"
71,MIN_REDUCTION+11, // "f"
72,MIN_REDUCTION+11, // "i"
73,MIN_REDUCTION+11, // "l"
74,MIN_REDUCTION+11, // "o"
75,MIN_REDUCTION+11, // "r"
76,MIN_REDUCTION+11, // "u"
77,MIN_REDUCTION+11, // "b"
78,MIN_REDUCTION+11, // "e"
79,MIN_REDUCTION+11, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,MIN_REDUCTION+11, // "h"
81,MIN_REDUCTION+11, // "n"
82,MIN_REDUCTION+11, // "t"
84,MIN_REDUCTION+11, // {199..218 231..250}
85,MIN_REDUCTION+11, // {193..198 225..230}
97,415, // "@"
107,MIN_REDUCTION+57, // "["
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 452
0x80000000|700, // match move
0x80000000|1294, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 453
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 454
MIN_REDUCTION+15, // (default reduction)
  }
,
{ // state 455
7,1103, // ID
15,1025, // `(
31,1061, // <expr>
35,1107, // <expr8>
37,174, // <expr7>
39,155, // <expr6>
41,1266, // <expr5>
44,772, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 456
0x80000000|257, // match move
0x80000000|1210, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 457
22,MIN_REDUCTION+163, // `[
107,MIN_REDUCTION+163, // "["
MIN_REDUCTION+163, // (default reduction)
  }
,
{ // state 458
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1226, // letter128
84,968, // {199..218 231..250}
85,968, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,284, // digit128
90,714, // {176..185}
115,160, // idChar*
116,146, // $$0
121,301, // idChar
122,1272, // "_"
123,495, // idChar128
124,209, // {223}
  }
,
{ // state 459
22,MIN_REDUCTION+163, // `[
107,MIN_REDUCTION+163, // "["
MIN_REDUCTION+163, // (default reduction)
  }
,
{ // state 460
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 461
91,568, // ws
92,746, // " "
93,793, // {10}
MIN_REDUCTION+80, // (default reduction)
  }
,
{ // state 462
MIN_REDUCTION+17, // (default reduction)
  }
,
{ // state 463
0x80000000|1, // match move
0x80000000|1251, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 464
2,397, // ws*
91,378, // ws
92,424, // " "
93,1108, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 465
5,268, // <class decl>
6,1150, // `class
94,224, // "#"
MIN_REDUCTION+3, // (default reduction)
  }
,
{ // state 466
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1170, // letter128
84,1009, // {199..218 231..250}
85,1009, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,270, // digit128
90,731, // {176..185}
115,177, // idChar*
116,107, // $$0
121,301, // idChar
122,1272, // "_"
123,549, // idChar128
124,230, // {223}
  }
,
{ // state 467
2,837, // ws*
91,976, // ws
92,1011, // " "
93,1258, // {10}
MIN_REDUCTION+101, // (default reduction)
  }
,
{ // state 468
0x80000000|1, // match move
0x80000000|1255, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 469
2,1217, // ws*
91,18, // ws
92,403, // " "
93,1113, // {10}
MIN_REDUCTION+107, // (default reduction)
  }
,
{ // state 470
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1168, // letter128
84,1006, // {199..218 231..250}
85,1006, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,273, // digit128
90,734, // {176..185}
115,178, // idChar*
116,104, // $$0
121,301, // idChar
122,1272, // "_"
123,555, // idChar128
124,235, // {223}
  }
,
{ // state 471
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 472
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,70, // letter128
84,1157, // {199..218 231..250}
85,1157, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1390, // digit128
90,323, // {176..185}
115,418, // idChar*
116,831, // $$0
121,301, // idChar
122,1272, // "_"
123,545, // idChar128
124,404, // {223}
  }
,
{ // state 473
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 474
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 475
0x80000000|694, // match move
0x80000000|783, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 476
22,MIN_REDUCTION+163, // `[
107,MIN_REDUCTION+163, // "["
MIN_REDUCTION+163, // (default reduction)
  }
,
{ // state 477
0x80000000|1, // match move
0x80000000|647, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 478
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 479
2,1293, // ws*
91,976, // ws
92,1011, // " "
93,1258, // {10}
MIN_REDUCTION+105, // (default reduction)
  }
,
{ // state 480
0x80000000|967, // match move
0x80000000|1036, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 481
-1, // $$start
-1, // <start>
-1, // ws*
-1, // <program>
-1, // <class decl>+
-1, // <class decl>
-1, // `class
1195, // ID
1204, // `{
-1, // <decl in class>*
1370, // `}
-1, // <decl in class>
-1, // <method decl>
-1, // `public
-1, // `void
774, // `(
-1, // `)
325, // <stmt>*
1367, // <type>
704, // `int
820, // `boolean
-1, // <empty bracket pair>
-1, // `[
-1, // `]
1162, // <stmt>
1001, // <assign>
-1, // `;
1152, // `break
543, // `++
1052, // `--
1242, // `if
425, // <expr>
-1, // `else
445, // <local var decl>
-1, // `=
1130, // <expr8>
-1, // `||
124, // <expr7>
-1, // `&&
116, // <expr6>
-1, // `==
1361, // <expr5>
-1, // `!=
-1, // `<
836, // <expr4>
-1, // `>
-1, // `<=
-1, // `>=
-1, // `instanceof
799, // `+
716, // <expr3>
248, // `-
-1, // `*
530, // <expr2>
-1, // `/
-1, // `%
840, // <cast expr>
658, // <expr1>
1231, // <unary expr>
161, // `!
-1, // `.
49, // INTLIT
65, // `true
747, // `false
1182, // `null
429, // `this
313, // letter
848, // "a"
848, // "p"
848, // "v"
848, // "c"
848, // "f"
848, // "i"
848, // "l"
848, // "o"
848, // "r"
848, // "u"
848, // "b"
848, // "e"
848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
848, // "h"
848, // "n"
848, // "t"
1185, // letter128
422, // {199..218 231..250}
422, // {193..198 225..230}
-1, // digit
380, // {"1".."9"}
504, // "0"
787, // digit128
631, // {176..185}
-1, // ws
-1, // " "
-1, // {10}
1068, // "#"
50, // "+"
1186, // "!"
331, // "@"
-1, // "%"
-1, // "&"
-1, // "*"
1067, // "("
-1, // ")"
527, // "{"
1049, // "}"
205, // "-"
-1, // "="
-1, // "["
-1, // "]"
-1, // "|"
-1, // "<"
-1, // ">"
-1, // "."
-1, // ";"
-1, // "/"
-1, // idChar*
-1, // $$0
-1, // digit*
-1, // $$1
-1, // hexDigit*
-1, // $$2
-1, // idChar
-1, // "_"
-1, // idChar128
-1, // {223}
-1, // hexDigit
-1, // hexDigit128
-1, // $
-1, // $NT
  }
,
{ // state 482
73,1104, // "l"
  }
,
{ // state 483
2,1013, // ws*
91,979, // ws
92,609, // " "
93,41, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 484
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 485
MIN_REDUCTION+17, // (default reduction)
  }
,
{ // state 486
91,611, // ws
92,473, // " "
93,1220, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 487
0x80000000|1, // match move
0x80000000|733, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 488
52,675, // `*
54,345, // `/
55,493, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+42, // (default reduction)
  }
,
{ // state 489
95,1256, // "+"
96,1143, // "!"
99,1004, // "&"
105,1176, // "-"
106,942, // "="
109,676, // "|"
110,40, // "<"
111,1388, // ">"
  }
,
{ // state 490
0x80000000|1, // match move
0x80000000|730, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 491
91,383, // ws
92,556, // " "
93,53, // {10}
MIN_REDUCTION+76, // (default reduction)
  }
,
{ // state 492
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+138, // (default reduction)
  }
,
{ // state 493
7,1213, // ID
15,737, // `(
49,770, // `+
51,216, // `-
53,882, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 494
2,951, // ws*
22,MIN_REDUCTION+179, // `[
91,816, // ws
92,68, // " "
93,963, // {10}
107,MIN_REDUCTION+179, // "["
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 495
2,1281, // ws*
91,954, // ws
92,556, // " "
93,53, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 496
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 497
7,MIN_REDUCTION+11, // ID
22,MIN_REDUCTION+57, // `[
28,560, // `++
29,812, // `--
67,MIN_REDUCTION+11, // "a"
68,MIN_REDUCTION+11, // "p"
69,MIN_REDUCTION+11, // "v"
70,MIN_REDUCTION+11, // "c"
71,MIN_REDUCTION+11, // "f"
72,MIN_REDUCTION+11, // "i"
73,MIN_REDUCTION+11, // "l"
74,MIN_REDUCTION+11, // "o"
75,MIN_REDUCTION+11, // "r"
76,MIN_REDUCTION+11, // "u"
77,MIN_REDUCTION+11, // "b"
78,MIN_REDUCTION+11, // "e"
79,MIN_REDUCTION+11, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,MIN_REDUCTION+11, // "h"
81,MIN_REDUCTION+11, // "n"
82,MIN_REDUCTION+11, // "t"
84,MIN_REDUCTION+11, // {199..218 231..250}
85,MIN_REDUCTION+11, // {193..198 225..230}
97,489, // "@"
107,MIN_REDUCTION+57, // "["
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 498
0x80000000|550, // match move
0x80000000|1316, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 499
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 500
0x80000000|1, // match move
0x80000000|1369, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 501
2,718, // ws*
91,1010, // ws
92,1074, // " "
93,1290, // {10}
MIN_REDUCTION+133, // (default reduction)
  }
,
{ // state 502
MIN_REDUCTION+45, // (default reduction)
  }
,
{ // state 503
0x80000000|1, // match move
0x80000000|251, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 504
67,1126, // "a"
68,1126, // "p"
69,1126, // "v"
70,1126, // "c"
71,1126, // "f"
72,1126, // "i"
73,1126, // "l"
74,1126, // "o"
75,1126, // "r"
76,1126, // "u"
77,1126, // "b"
78,1126, // "e"
79,1126, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,1126, // "h"
81,1126, // "n"
82,1126, // "t"
85,2, // {193..198 225..230}
87,1126, // {"1".."9"}
88,1126, // "0"
90,2, // {176..185}
119,834, // hexDigit*
120,97, // $$2
125,1245, // hexDigit
126,199, // hexDigit128
  }
,
{ // state 505
0x80000000|939, // match move
0x80000000|1239, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 506
22,MIN_REDUCTION+161, // `[
107,MIN_REDUCTION+161, // "["
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 507
91,388, // ws
92,1209, // " "
93,1306, // {10}
MIN_REDUCTION+92, // (default reduction)
  }
,
{ // state 508
82,687, // "t"
  }
,
{ // state 509
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 510
2,613, // ws*
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 511
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 512
21,1336, // <empty bracket pair>
22,149, // `[
107,1202, // "["
MIN_REDUCTION+39, // (default reduction)
  }
,
{ // state 513
MIN_REDUCTION+47, // (default reduction)
  }
,
{ // state 514
71,814, // "f"
81,396, // "n"
82,1291, // "t"
  }
,
{ // state 515
26,1184, // `;
113,34, // ";"
  }
,
{ // state 516
128,MIN_REDUCTION+176, // $NT
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 517
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 518
2,977, // ws*
91,965, // ws
92,627, // " "
93,67, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 519
MIN_REDUCTION+2, // (default reduction)
  }
,
{ // state 520
91,372, // ws
92,620, // " "
93,73, // {10}
MIN_REDUCTION+76, // (default reduction)
  }
,
{ // state 521
0x80000000|1, // match move
0x80000000|314, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 522
2,981, // ws*
91,961, // ws
92,620, // " "
93,73, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 523
91,362, // ws
92,627, // " "
93,67, // {10}
MIN_REDUCTION+76, // (default reduction)
  }
,
{ // state 524
2,980, // ws*
91,1323, // ws
92,1225, // " "
93,1097, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 525
MIN_REDUCTION+47, // (default reduction)
  }
,
{ // state 526
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,8, // letter128
84,1102, // {199..218 231..250}
85,1102, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1353, // digit128
90,375, // {176..185}
116,48, // $$0
121,1318, // idChar
122,1272, // "_"
123,464, // idChar128
124,449, // {223}
  }
,
{ // state 527
2,1249, // ws*
91,202, // ws
92,760, // " "
93,89, // {10}
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 528
0x80000000|1, // match move
0x80000000|590, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 529
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 530
MIN_REDUCTION+47, // (default reduction)
  }
,
{ // state 531
0x80000000|1070, // match move
0x80000000|946, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 532
78,569, // "e"
  }
,
{ // state 533
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 534
21,1321, // <empty bracket pair>
22,180, // `[
107,1202, // "["
MIN_REDUCTION+39, // (default reduction)
  }
,
{ // state 535
0x80000000|1070, // match move
0x80000000|929, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 536
MIN_REDUCTION+47, // (default reduction)
  }
,
{ // state 537
2,253, // ws*
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 538
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 539
2,MIN_REDUCTION+161, // ws*
92,MIN_REDUCTION+161, // " "
93,MIN_REDUCTION+161, // {10}
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 540
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1192, // letter128
84,896, // {199..218 231..250}
85,896, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1199, // digit128
90,1295, // {176..185}
116,529, // $$0
121,1318, // idChar
122,1272, // "_"
123,16, // idChar128
124,1386, // {223}
  }
,
{ // state 541
0x80000000|1070, // match move
0x80000000|930, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 542
67,1126, // "a"
68,1126, // "p"
69,1126, // "v"
70,1126, // "c"
71,1126, // "f"
72,1126, // "i"
73,1126, // "l"
74,1126, // "o"
75,1126, // "r"
76,1126, // "u"
77,1126, // "b"
78,1126, // "e"
79,1126, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,1126, // "h"
81,1126, // "n"
82,1126, // "t"
85,79, // {193..198 225..230}
87,1126, // {"1".."9"}
88,1126, // "0"
90,79, // {176..185}
119,806, // hexDigit*
120,282, // $$2
125,1245, // hexDigit
126,348, // hexDigit128
  }
,
{ // state 543
7,1116, // ID
66,1382, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1261, // letter128
84,896, // {199..218 231..250}
85,896, // {193..198 225..230}
  }
,
{ // state 544
7,228, // ID
66,439, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,246, // letter128
84,1135, // {199..218 231..250}
85,1135, // {193..198 225..230}
  }
,
{ // state 545
2,486, // ws*
91,328, // ws
92,473, // " "
93,1220, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 546
MIN_REDUCTION+20, // (default reduction)
  }
,
{ // state 547
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,173, // letter128
84,1083, // {199..218 231..250}
85,1083, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1341, // digit128
90,419, // {176..185}
116,85, // $$0
121,1318, // idChar
122,1272, // "_"
123,669, // idChar128
124,474, // {223}
  }
,
{ // state 548
7,387, // ID
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
  }
,
{ // state 549
2,1285, // ws*
91,965, // ws
92,627, // " "
93,67, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 550
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 551
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 552
22,843, // `[
60,548, // `.
107,597, // "["
112,77, // "."
MIN_REDUCTION+50, // (default reduction)
  }
,
{ // state 553
21,1319, // <empty bracket pair>
22,170, // `[
107,1202, // "["
MIN_REDUCTION+39, // (default reduction)
  }
,
{ // state 554
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 555
2,1311, // ws*
91,961, // ws
92,620, // " "
93,73, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 556
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 557
2,120, // ws*
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 558
22,MIN_REDUCTION+68, // `[
107,MIN_REDUCTION+68, // "["
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 559
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 560
MIN_REDUCTION+16, // (default reduction)
  }
,
{ // state 561
2,1136, // ws*
91,52, // ws
92,1030, // " "
93,1322, // {10}
128,MIN_REDUCTION+125, // $NT
  }
,
{ // state 562
0x80000000|1, // match move
0x80000000|501, // no-match move
// T-test match for "=":
106,
  }
,
{ // state 563
2,810, // ws*
22,MIN_REDUCTION+87, // `[
91,1164, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+87, // "["
MIN_REDUCTION+87, // (default reduction)
  }
,
{ // state 564
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 565
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 566
0x80000000|1, // match move
0x80000000|907, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 567
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 568
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 569
73,1328, // "l"
  }
,
{ // state 570
38,54, // `&&
97,825, // "@"
MIN_REDUCTION+28, // (default reduction)
  }
,
{ // state 571
0x80000000|1, // match move
0x80000000|904, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 572
38,56, // `&&
97,825, // "@"
MIN_REDUCTION+28, // (default reduction)
  }
,
{ // state 573
2,949, // ws*
91,328, // ws
92,473, // " "
93,1220, // {10}
MIN_REDUCTION+109, // (default reduction)
  }
,
{ // state 574
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 575
MIN_REDUCTION+53, // (default reduction)
  }
,
{ // state 576
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 577
22,MIN_REDUCTION+68, // `[
107,MIN_REDUCTION+68, // "["
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 578
22,MIN_REDUCTION+68, // `[
107,MIN_REDUCTION+68, // "["
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 579
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 580
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 581
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 582
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 583
2,742, // ws*
22,MIN_REDUCTION+87, // `[
91,1200, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+87, // "["
MIN_REDUCTION+87, // (default reduction)
  }
,
{ // state 584
72,1260, // "i"
77,1229, // "b"
  }
,
{ // state 585
2,761, // ws*
22,MIN_REDUCTION+87, // `[
91,1201, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+87, // "["
MIN_REDUCTION+87, // (default reduction)
  }
,
{ // state 586
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 587
0x80000000|1, // match move
0x80000000|881, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 588
2,1193, // ws*
91,1323, // ws
92,1225, // " "
93,1097, // {10}
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 589
16,27, // `)
102,664, // ")"
  }
,
{ // state 590
22,MIN_REDUCTION+146, // `[
91,680, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+146, // "["
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 591
2,1180, // ws*
91,979, // ws
92,609, // " "
93,41, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 592
22,MIN_REDUCTION+68, // `[
107,MIN_REDUCTION+68, // "["
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 593
2,778, // ws*
MIN_REDUCTION+139, // (default reduction)
  }
,
{ // state 594
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 595
2,703, // ws*
91,249, // ws
92,782, // " "
93,319, // {10}
MIN_REDUCTION+71, // (default reduction)
  }
,
{ // state 596
73,35, // "l"
  }
,
{ // state 597
2,1221, // ws*
91,1138, // ws
92,147, // " "
93,43, // {10}
MIN_REDUCTION+123, // (default reduction)
  }
,
{ // state 598
2,MIN_REDUCTION+159, // ws*
92,MIN_REDUCTION+159, // " "
93,MIN_REDUCTION+159, // {10}
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 599
78,482, // "e"
  }
,
{ // state 600
22,MIN_REDUCTION+178, // `[
91,1174, // ws
92,68, // " "
93,963, // {10}
107,MIN_REDUCTION+178, // "["
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 601
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 602
0x80000000|250, // match move
0x80000000|1289, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 603
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 604
38,333, // `&&
97,825, // "@"
MIN_REDUCTION+28, // (default reduction)
  }
,
{ // state 605
0x80000000|1, // match move
0x80000000|1082, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 606
2,613, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 607
7,1111, // ID
15,771, // `(
44,1269, // <expr4>
49,801, // `+
50,723, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 608
7,1115, // ID
15,774, // `(
44,1276, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 609
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 610
0x80000000|252, // match move
0x80000000|1286, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 611
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 612
91,MIN_REDUCTION+68, // ws
92,MIN_REDUCTION+68, // " "
93,MIN_REDUCTION+68, // {10}
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 613
0x80000000|1334, // match move
0x80000000|241, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 614
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 615
7,1103, // ID
15,1025, // `(
49,745, // `+
51,244, // `-
53,920, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 616
2,120, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 617
91,699, // ws
92,763, // " "
93,726, // {10}
MIN_REDUCTION+108, // (default reduction)
  }
,
{ // state 618
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 619
7,1111, // ID
15,771, // `(
49,801, // `+
51,258, // `-
53,909, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 620
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 621
MIN_REDUCTION+16, // (default reduction)
  }
,
{ // state 622
91,565, // ws
92,405, // " "
93,1110, // {10}
MIN_REDUCTION+78, // (default reduction)
  }
,
{ // state 623
22,MIN_REDUCTION+69, // `[
107,MIN_REDUCTION+69, // "["
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 624
0x80000000|245, // match move
0x80000000|1354, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 625
7,1213, // ID
15,737, // `(
44,1381, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 626
127,MIN_REDUCTION+0, // $
  }
,
{ // state 627
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 628
7,1115, // ID
15,774, // `(
49,799, // `+
51,248, // `-
53,905, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 629
0x80000000|789, // match move
0x80000000|640, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 630
2,503, // ws*
22,MIN_REDUCTION+181, // `[
91,1164, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+181, // "["
MIN_REDUCTION+181, // (default reduction)
  }
,
{ // state 631
0x80000000|789, // match move
0x80000000|634, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 632
2,523, // ws*
91,965, // ws
92,627, // " "
93,67, // {10}
MIN_REDUCTION+77, // (default reduction)
  }
,
{ // state 633
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 634
22,MIN_REDUCTION+67, // `[
107,MIN_REDUCTION+67, // "["
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 635
22,MIN_REDUCTION+152, // `[
91,722, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+152, // "["
MIN_REDUCTION+152, // (default reduction)
  }
,
{ // state 636
2,1191, // ws*
91,954, // ws
92,556, // " "
93,53, // {10}
MIN_REDUCTION+71, // (default reduction)
  }
,
{ // state 637
2,520, // ws*
91,961, // ws
92,620, // " "
93,73, // {10}
MIN_REDUCTION+77, // (default reduction)
  }
,
{ // state 638
22,MIN_REDUCTION+67, // `[
107,MIN_REDUCTION+67, // "["
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 639
MIN_REDUCTION+165, // (default reduction)
  }
,
{ // state 640
22,MIN_REDUCTION+67, // `[
107,MIN_REDUCTION+67, // "["
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 641
74,788, // "o"
  }
,
{ // state 642
7,1111, // ID
15,771, // `(
49,801, // `+
51,258, // `-
53,690, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 643
7,1115, // ID
15,774, // `(
49,799, // `+
51,248, // `-
53,689, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 644
0x80000000|901, // match move
0x80000000|1389, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 645
0x80000000|218, // match move
0x80000000|1253, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 646
2,192, // ws*
91,961, // ws
92,620, // " "
93,73, // {10}
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 647
22,MIN_REDUCTION+146, // `[
91,722, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+146, // "["
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 648
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,173, // letter128
84,1083, // {199..218 231..250}
85,1083, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1341, // digit128
90,419, // {176..185}
115,547, // idChar*
116,983, // $$0
121,301, // idChar
122,1272, // "_"
123,669, // idChar128
124,474, // {223}
  }
,
{ // state 649
7,1103, // ID
15,1025, // `(
44,1096, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 650
22,MIN_REDUCTION+69, // `[
107,MIN_REDUCTION+69, // "["
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 651
2,157, // ws*
91,965, // ws
92,627, // " "
93,67, // {10}
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 652
22,MIN_REDUCTION+69, // `[
107,MIN_REDUCTION+69, // "["
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 653
0x80000000|1, // match move
0x80000000|1159, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 654
MIN_REDUCTION+44, // (default reduction)
  }
,
{ // state 655
7,1103, // ID
15,1025, // `(
49,745, // `+
51,244, // `-
53,698, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 656
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 657
0x80000000|903, // match move
0x80000000|1365, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 658
0x80000000|1, // match move
0x80000000|164, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 659
7,1115, // ID
15,774, // `(
44,1161, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 660
2,507, // ws*
91,603, // ws
92,1209, // " "
93,1306, // {10}
MIN_REDUCTION+93, // (default reduction)
  }
,
{ // state 661
52,655, // `*
54,312, // `/
55,615, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+42, // (default reduction)
  }
,
{ // state 662
72,1387, // "i"
77,1283, // "b"
  }
,
{ // state 663
7,1111, // ID
15,771, // `(
44,1160, // <expr4>
49,801, // `+
50,723, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 664
2,1134, // ws*
91,435, // ws
92,746, // " "
93,793, // {10}
MIN_REDUCTION+109, // (default reduction)
  }
,
{ // state 665
2,281, // ws*
22,MIN_REDUCTION+125, // `[
91,1200, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+125, // "["
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 666
96,1143, // "!"
99,1004, // "&"
106,942, // "="
109,676, // "|"
  }
,
{ // state 667
72,1384, // "i"
77,1268, // "b"
  }
,
{ // state 668
2,1212, // ws*
91,961, // ws
92,620, // " "
93,73, // {10}
MIN_REDUCTION+71, // (default reduction)
  }
,
{ // state 669
2,436, // ws*
91,17, // ws
92,405, // " "
93,1110, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 670
7,1103, // ID
15,1025, // `(
31,1034, // <expr>
35,1107, // <expr8>
37,174, // <expr7>
39,155, // <expr6>
41,1266, // <expr5>
44,772, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 671
34,123, // `=
106,866, // "="
  }
,
{ // state 672
2,1214, // ws*
91,965, // ws
92,627, // " "
93,67, // {10}
MIN_REDUCTION+71, // (default reduction)
  }
,
{ // state 673
0x80000000|789, // match move
0x80000000|688, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 674
0x80000000|1, // match move
0x80000000|163, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 675
7,1213, // ID
15,737, // `(
49,770, // `+
51,216, // `-
53,654, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 676
2,135, // ws*
91,1080, // ws
92,751, // " "
93,878, // {10}
MIN_REDUCTION+127, // (default reduction)
  }
,
{ // state 677
0x80000000|1282, // match move
0x80000000|176, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 678
91,169, // ws
92,1074, // " "
93,1290, // {10}
MIN_REDUCTION+130, // (default reduction)
  }
,
{ // state 679
2,622, // ws*
91,17, // ws
92,405, // " "
93,1110, // {10}
MIN_REDUCTION+79, // (default reduction)
  }
,
{ // state 680
0x80000000|1, // match move
0x80000000|890, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 681
0x80000000|1, // match move
0x80000000|1148, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 682
22,MIN_REDUCTION+69, // `[
107,MIN_REDUCTION+69, // "["
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 683
2,277, // ws*
22,MIN_REDUCTION+125, // `[
91,1201, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+125, // "["
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 684
0x80000000|1, // match move
0x80000000|1146, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 685
10,1271, // `}
11,414, // <decl in class>
12,261, // <method decl>
13,1312, // `public
94,1243, // "#"
104,876, // "}"
  }
,
{ // state 686
52,655, // `*
54,312, // `/
55,615, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+43, // (default reduction)
  }
};
}
private class Initter3{
public int doInit(int startIdx) {
  for (int i = 0; i < myParseTable.length; i++) {
    parseTable[i+startIdx] = myParseTable[i];
  }
  return myParseTable.length;
}
private final int[][] myParseTable = {
{ // state 687
2,709, // ws*
91,249, // ws
92,782, // " "
93,319, // {10}
MIN_REDUCTION+77, // (default reduction)
  }
,
{ // state 688
22,MIN_REDUCTION+67, // `[
107,MIN_REDUCTION+67, // "["
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 689
MIN_REDUCTION+44, // (default reduction)
  }
,
{ // state 690
MIN_REDUCTION+44, // (default reduction)
  }
,
{ // state 691
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 692
2,749, // ws*
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 693
MIN_REDUCTION+53, // (default reduction)
  }
,
{ // state 694
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 695
22,MIN_REDUCTION+90, // `[
91,680, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+90, // "["
MIN_REDUCTION+90, // (default reduction)
  }
,
{ // state 696
49,868, // `+
51,887, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+37, // (default reduction)
  }
,
{ // state 697
2,118, // ws*
91,954, // ws
92,556, // " "
93,53, // {10}
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 698
MIN_REDUCTION+44, // (default reduction)
  }
,
{ // state 699
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 700
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 701
0x80000000|1, // match move
0x80000000|871, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 702
MIN_REDUCTION+23, // (default reduction)
  }
,
{ // state 703
91,1069, // ws
92,782, // " "
93,319, // {10}
MIN_REDUCTION+70, // (default reduction)
  }
,
{ // state 704
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 705
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 706
91,75, // ws
92,1310, // " "
93,1054, // {10}
MIN_REDUCTION+72, // (default reduction)
  }
,
{ // state 707
2,982, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+139, // (default reduction)
  }
,
{ // state 708
0x80000000|1, // match move
0x80000000|863, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 709
91,1069, // ws
92,782, // " "
93,319, // {10}
MIN_REDUCTION+76, // (default reduction)
  }
,
{ // state 710
0x80000000|789, // match move
0x80000000|713, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 711
0x80000000|1, // match move
0x80000000|233, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 712
2,450, // ws*
22,MIN_REDUCTION+181, // `[
91,1200, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+181, // "["
MIN_REDUCTION+181, // (default reduction)
  }
,
{ // state 713
22,MIN_REDUCTION+67, // `[
107,MIN_REDUCTION+67, // "["
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 714
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 715
2,448, // ws*
22,MIN_REDUCTION+181, // `[
91,1201, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+181, // "["
MIN_REDUCTION+181, // (default reduction)
  }
,
{ // state 716
52,643, // `*
54,322, // `/
55,628, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+43, // (default reduction)
  }
,
{ // state 717
22,MIN_REDUCTION+160, // `[
107,MIN_REDUCTION+160, // "["
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 718
91,169, // ws
92,1074, // " "
93,1290, // {10}
MIN_REDUCTION+132, // (default reduction)
  }
,
{ // state 719
52,642, // `*
54,321, // `/
55,619, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+42, // (default reduction)
  }
,
{ // state 720
2,491, // ws*
91,954, // ws
92,556, // " "
93,53, // {10}
MIN_REDUCTION+77, // (default reduction)
  }
,
{ // state 721
2,1089, // ws*
91,979, // ws
92,609, // " "
93,41, // {10}
MIN_REDUCTION+71, // (default reduction)
  }
,
{ // state 722
0x80000000|1, // match move
0x80000000|847, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 723
52,642, // `*
54,321, // `/
55,619, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+43, // (default reduction)
  }
,
{ // state 724
MIN_REDUCTION+156, // (default reduction)
  }
,
{ // state 725
2,320, // ws*
22,MIN_REDUCTION+125, // `[
91,1140, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+125, // "["
MIN_REDUCTION+125, // (default reduction)
  }
,
{ // state 726
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 727
MIN_REDUCTION+53, // (default reduction)
  }
,
{ // state 728
MIN_REDUCTION+53, // (default reduction)
  }
,
{ // state 729
0x80000000|912, // match move
0x80000000|1338, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 730
22,MIN_REDUCTION+146, // `[
91,701, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+146, // "["
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 731
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 732
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,8, // letter128
84,1102, // {199..218 231..250}
85,1102, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1353, // digit128
90,375, // {176..185}
115,526, // idChar*
116,960, // $$0
121,301, // idChar
122,1272, // "_"
123,464, // idChar128
124,449, // {223}
  }
,
{ // state 733
22,MIN_REDUCTION+146, // `[
91,708, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+146, // "["
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 734
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 735
0x80000000|1, // match move
0x80000000|918, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 736
7,1213, // ID
15,737, // `(
41,1351, // <expr5>
44,947, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 737
7,1093, // ID
18,1024, // <type>
19,1085, // `int
20,1284, // `boolean
66,237, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,748, // letter128
84,1071, // {199..218 231..250}
85,1071, // {193..198 225..230}
94,1156, // "#"
  }
,
{ // state 738
0x80000000|971, // match move
0x80000000|1227, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 739
22,MIN_REDUCTION+65, // `[
107,MIN_REDUCTION+65, // "["
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 740
0x80000000|1, // match move
0x80000000|1129, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 741
2,1147, // ws*
22,MIN_REDUCTION+89, // `[
91,1164, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+89, // "["
MIN_REDUCTION+89, // (default reduction)
  }
,
{ // state 742
0x80000000|1, // match move
0x80000000|1045, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 743
0x80000000|1, // match move
0x80000000|229, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 744
0x80000000|1, // match move
0x80000000|232, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 745
7,1103, // ID
49,745, // `+
51,244, // `-
57,711, // <expr1>
58,693, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 746
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 747
0x80000000|1, // match move
0x80000000|1137, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 748
2,1131, // ws*
91,1323, // ws
92,1225, // " "
93,1097, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 749
0x80000000|1334, // match move
0x80000000|928, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 750
0x80000000|382, // match move
0x80000000|260, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 751
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 752
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 753
7,1115, // ID
15,774, // `(
41,193, // <expr5>
44,836, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 754
7,1111, // ID
15,771, // `(
41,181, // <expr5>
44,830, // <expr4>
49,801, // `+
50,723, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 755
7,956, // ID
8,182, // `{
15,774, // `(
18,1367, // <type>
19,704, // `int
20,820, // `boolean
24,959, // <stmt>
25,973, // <assign>
27,1154, // `break
28,168, // `++
29,132, // `--
30,832, // `if
31,425, // <expr>
33,796, // <local var decl>
35,1130, // <expr8>
37,124, // <expr7>
39,116, // <expr6>
41,1361, // <expr5>
44,836, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,313, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1185, // letter128
84,422, // {199..218 231..250}
85,422, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,1068, // "#"
95,50, // "+"
96,1186, // "!"
97,331, // "@"
101,1067, // "("
103,527, // "{"
105,205, // "-"
  }
,
{ // state 756
2,400, // ws*
22,MIN_REDUCTION+181, // `[
91,1140, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+181, // "["
MIN_REDUCTION+181, // (default reduction)
  }
,
{ // state 757
49,845, // `+
51,911, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+37, // (default reduction)
  }
,
{ // state 758
49,844, // `+
51,914, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+37, // (default reduction)
  }
,
{ // state 759
22,MIN_REDUCTION+152, // `[
91,680, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+152, // "["
MIN_REDUCTION+152, // (default reduction)
  }
,
{ // state 760
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 761
0x80000000|1, // match move
0x80000000|1040, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 762
91,1287, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+140, // (default reduction)
  }
,
{ // state 763
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 764
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 765
0x80000000|1, // match move
0x80000000|1118, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 766
0x80000000|1179, // match move
0x80000000|638, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 767
MIN_REDUCTION+7, // (default reduction)
  }
,
{ // state 768
128,MIN_REDUCTION+13, // $NT
  }
,
{ // state 769
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,221, // letter128
84,1135, // {199..218 231..250}
85,1135, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1236, // digit128
90,452, // {176..185}
116,1360, // $$0
121,1318, // idChar
122,1272, // "_"
123,865, // idChar128
124,368, // {223}
  }
,
{ // state 770
7,1213, // ID
49,770, // `+
51,216, // `-
57,442, // <expr1>
58,575, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 771
7,1093, // ID
18,1072, // <type>
19,1085, // `int
20,1284, // `boolean
66,237, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,748, // letter128
84,1071, // {199..218 231..250}
85,1071, // {193..198 225..230}
94,1156, // "#"
  }
,
{ // state 772
49,807, // `+
51,895, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+40, // (default reduction)
  }
,
{ // state 773
MIN_REDUCTION+20, // (default reduction)
  }
,
{ // state 774
7,1093, // ID
18,1076, // <type>
19,1085, // `int
20,1284, // `boolean
66,237, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,748, // letter128
84,1071, // {199..218 231..250}
85,1071, // {193..198 225..230}
94,1156, // "#"
  }
,
{ // state 775
0x80000000|1163, // match move
0x80000000|1121, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 776
7,1111, // ID
15,771, // `(
41,72, // <expr5>
44,830, // <expr4>
49,801, // `+
50,723, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 777
0x80000000|846, // match move
0x80000000|1270, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 778
0x80000000|925, // match move
0x80000000|492, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 779
7,1115, // ID
15,774, // `(
41,36, // <expr5>
44,836, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 780
0x80000000|1165, // match move
0x80000000|1123, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 781
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 782
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 783
22,MIN_REDUCTION+159, // `[
107,MIN_REDUCTION+159, // "["
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 784
0x80000000|829, // match move
0x80000000|1114, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 785
MIN_REDUCTION+13, // (default reduction)
  }
,
{ // state 786
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 787
0x80000000|408, // match move
0x80000000|204, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 788
2,1332, // ws*
91,499, // ws
92,1310, // " "
93,1054, // {10}
MIN_REDUCTION+75, // (default reduction)
  }
,
{ // state 789
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 790
7,1103, // ID
15,1025, // `(
41,294, // <expr5>
44,772, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 791
7,1103, // ID
15,1025, // `(
41,327, // <expr5>
44,772, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 792
91,MIN_REDUCTION+176, // ws
92,MIN_REDUCTION+176, // " "
93,MIN_REDUCTION+176, // {10}
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 793
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 794
0x80000000|410, // match move
0x80000000|207, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 795
22,MIN_REDUCTION+178, // `[
91,722, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+178, // "["
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 796
26,431, // `;
113,1244, // ";"
  }
,
{ // state 797
91,580, // ws
92,82, // " "
93,179, // {10}
MIN_REDUCTION+96, // (default reduction)
  }
,
{ // state 798
49,807, // `+
51,895, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+37, // (default reduction)
  }
,
{ // state 799
7,1115, // ID
49,799, // `+
51,248, // `-
57,658, // <expr1>
58,728, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 800
22,MIN_REDUCTION+152, // `[
91,708, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+152, // "["
MIN_REDUCTION+152, // (default reduction)
  }
,
{ // state 801
7,1111, // ID
49,801, // `+
51,258, // `-
57,674, // <expr1>
58,727, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
105,205, // "-"
  }
,
{ // state 802
91,1287, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 803
16,1331, // `)
102,573, // ")"
  }
,
{ // state 804
MIN_REDUCTION+168, // (default reduction)
  }
,
{ // state 805
7,1213, // ID
15,737, // `(
41,1297, // <expr5>
44,947, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 806
67,1126, // "a"
68,1126, // "p"
69,1126, // "v"
70,1126, // "c"
71,1126, // "f"
72,1126, // "i"
73,1126, // "l"
74,1126, // "o"
75,1126, // "r"
76,1126, // "u"
77,1126, // "b"
78,1126, // "e"
79,1126, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,1126, // "h"
81,1126, // "n"
82,1126, // "t"
85,79, // {193..198 225..230}
87,1126, // {"1".."9"}
88,1126, // "0"
90,79, // {176..185}
120,69, // $$2
125,804, // hexDigit
126,348, // hexDigit128
  }
,
{ // state 807
7,1103, // ID
15,1025, // `(
49,745, // `+
50,292, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 808
22,MIN_REDUCTION+152, // `[
91,701, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+152, // "["
MIN_REDUCTION+152, // (default reduction)
  }
,
{ // state 809
0x80000000|1, // match move
0x80000000|1158, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 810
0x80000000|1, // match move
0x80000000|1066, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 811
0x80000000|1178, // match move
0x80000000|1144, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 812
MIN_REDUCTION+17, // (default reduction)
  }
,
{ // state 813
22,MIN_REDUCTION+68, // `[
107,MIN_REDUCTION+68, // "["
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 814
67,94, // "a"
  }
,
{ // state 815
0x80000000|437, // match move
0x80000000|243, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 816
0x80000000|574, // match move
0x80000000|24, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 817
MIN_REDUCTION+48, // (default reduction)
  }
,
{ // state 818
2,93, // ws*
91,302, // ws
92,369, // " "
93,633, // {10}
MIN_REDUCTION+95, // (default reduction)
  }
,
{ // state 819
MIN_REDUCTION+15, // (default reduction)
  }
,
{ // state 820
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 821
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 822
22,MIN_REDUCTION+154, // `[
107,MIN_REDUCTION+154, // "["
MIN_REDUCTION+154, // (default reduction)
  }
,
{ // state 823
0x80000000|517, // match move
0x80000000|10, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 824
22,MIN_REDUCTION+154, // `[
107,MIN_REDUCTION+154, // "["
MIN_REDUCTION+154, // (default reduction)
  }
,
{ // state 825
99,1004, // "&"
109,676, // "|"
  }
,
{ // state 826
67,44, // "a"
  }
,
{ // state 827
0x80000000|517, // match move
0x80000000|7, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 828
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 829
2,275, // ws*
  }
,
{ // state 830
49,845, // `+
51,911, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+40, // (default reduction)
  }
,
{ // state 831
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 832
15,670, // `(
101,1098, // "("
  }
,
{ // state 833
67,1126, // "a"
68,1126, // "p"
69,1126, // "v"
70,1126, // "c"
71,1126, // "f"
72,1126, // "i"
73,1126, // "l"
74,1126, // "o"
75,1126, // "r"
76,1126, // "u"
77,1126, // "b"
78,1126, // "e"
79,1126, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,1126, // "h"
81,1126, // "n"
82,1126, // "t"
85,15, // {193..198 225..230}
87,1126, // {"1".."9"}
88,1126, // "0"
90,15, // {176..185}
120,1346, // $$2
125,804, // hexDigit
126,210, // hexDigit128
  }
,
{ // state 834
67,1126, // "a"
68,1126, // "p"
69,1126, // "v"
70,1126, // "c"
71,1126, // "f"
72,1126, // "i"
73,1126, // "l"
74,1126, // "o"
75,1126, // "r"
76,1126, // "u"
77,1126, // "b"
78,1126, // "e"
79,1126, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,1126, // "h"
81,1126, // "n"
82,1126, // "t"
85,2, // {193..198 225..230}
87,1126, // {"1".."9"}
88,1126, // "0"
90,2, // {176..185}
120,1348, // $$2
125,804, // hexDigit
126,199, // hexDigit128
  }
,
{ // state 835
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 836
49,844, // `+
51,914, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+40, // (default reduction)
  }
,
{ // state 837
91,125, // ws
92,1011, // " "
93,1258, // {10}
MIN_REDUCTION+100, // (default reduction)
  }
,
{ // state 838
MIN_REDUCTION+48, // (default reduction)
  }
,
{ // state 839
0x80000000|409, // match move
0x80000000|506, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 840
MIN_REDUCTION+48, // (default reduction)
  }
,
{ // state 841
0x80000000|310, // match move
0x80000000|717, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 842
22,MIN_REDUCTION+59, // `[
107,MIN_REDUCTION+59, // "["
MIN_REDUCTION+59, // (default reduction)
  }
,
{ // state 843
7,1213, // ID
15,737, // `(
31,189, // <expr>
35,1166, // <expr8>
37,74, // <expr7>
39,90, // <expr6>
41,111, // <expr5>
44,947, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 844
7,1115, // ID
15,774, // `(
49,799, // `+
50,342, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 845
7,1111, // ID
15,771, // `(
49,801, // `+
50,324, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 846
2,143, // ws*
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 847
22,MIN_REDUCTION+176, // `[
107,MIN_REDUCTION+176, // "["
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 848
MIN_REDUCTION+64, // (default reduction)
  }
,
{ // state 849
22,MIN_REDUCTION+178, // `[
91,701, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+178, // "["
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 850
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 851
0x80000000|517, // match move
0x80000000|33, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 852
22,MIN_REDUCTION+178, // `[
91,708, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+178, // "["
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 853
91,365, // ws
92,1304, // " "
93,1012, // {10}
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 854
22,MIN_REDUCTION+154, // `[
107,MIN_REDUCTION+154, // "["
MIN_REDUCTION+154, // (default reduction)
  }
,
{ // state 855
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 856
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 857
2,407, // ws*
91,1292, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 858
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 859
0x80000000|1, // match move
0x80000000|759, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 860
0x80000000|1, // match move
0x80000000|552, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 861
2,400, // ws*
  }
,
{ // state 862
MIN_REDUCTION+48, // (default reduction)
  }
,
{ // state 863
22,MIN_REDUCTION+176, // `[
107,MIN_REDUCTION+176, // "["
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 864
0x80000000|557, // match move
0x80000000|616, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 865
0x80000000|510, // match move
0x80000000|606, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 866
2,1232, // ws*
91,1138, // ws
92,147, // " "
93,43, // {10}
MIN_REDUCTION+119, // (default reduction)
  }
,
{ // state 867
0x80000000|165, // match move
0x80000000|291, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 868
7,1213, // ID
15,737, // `(
49,770, // `+
50,1122, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 869
67,1126, // "a"
68,1126, // "p"
69,1126, // "v"
70,1126, // "c"
71,1126, // "f"
72,1126, // "i"
73,1126, // "l"
74,1126, // "o"
75,1126, // "r"
76,1126, // "u"
77,1126, // "b"
78,1126, // "e"
79,1126, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,1126, // "h"
81,1126, // "n"
82,1126, // "t"
85,22, // {193..198 225..230}
87,1126, // {"1".."9"}
88,1126, // "0"
90,22, // {176..185}
120,1320, // $$2
125,804, // hexDigit
126,240, // hexDigit128
  }
,
{ // state 870
67,42, // "a"
  }
,
{ // state 871
22,MIN_REDUCTION+176, // `[
107,MIN_REDUCTION+176, // "["
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 872
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 873
MIN_REDUCTION+52, // (default reduction)
  }
,
{ // state 874
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 875
MIN_REDUCTION+16, // (default reduction)
  }
,
{ // state 876
2,126, // ws*
91,786, // ws
92,1218, // " "
93,886, // {10}
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 877
MIN_REDUCTION+170, // (default reduction)
  }
,
{ // state 878
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 879
2,503, // ws*
  }
,
{ // state 880
22,MIN_REDUCTION+59, // `[
107,MIN_REDUCTION+59, // "["
MIN_REDUCTION+59, // (default reduction)
  }
,
{ // state 881
22,MIN_REDUCTION+150, // `[
107,MIN_REDUCTION+150, // "["
MIN_REDUCTION+150, // (default reduction)
  }
,
{ // state 882
MIN_REDUCTION+46, // (default reduction)
  }
,
{ // state 883
2,450, // ws*
  }
,
{ // state 884
2,448, // ws*
  }
,
{ // state 885
7,1213, // ID
15,737, // `(
31,3, // <expr>
35,1166, // <expr8>
37,74, // <expr7>
39,90, // <expr6>
41,111, // <expr5>
44,947, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 886
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 887
7,1213, // ID
15,737, // `(
49,770, // `+
50,488, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 888
86,1105, // digit
87,1153, // {"1".."9"}
88,1153, // "0"
89,298, // digit128
90,673, // {176..185}
118,735, // $$1
  }
,
{ // state 889
MIN_REDUCTION+19, // (default reduction)
  }
,
{ // state 890
22,MIN_REDUCTION+176, // `[
107,MIN_REDUCTION+176, // "["
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 891
22,MIN_REDUCTION+57, // `[
107,MIN_REDUCTION+57, // "["
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 892
22,MIN_REDUCTION+178, // `[
91,680, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+178, // "["
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 893
67,166, // "a"
  }
,
{ // state 894
22,MIN_REDUCTION+57, // `[
107,MIN_REDUCTION+57, // "["
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 895
7,1103, // ID
15,1025, // `(
49,745, // `+
50,661, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 896
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 897
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 898
MIN_REDUCTION+163, // (default reduction)
  }
,
{ // state 899
22,MIN_REDUCTION+59, // `[
107,MIN_REDUCTION+59, // "["
MIN_REDUCTION+59, // (default reduction)
  }
,
{ // state 900
91,579, // ws
92,438, // " "
93,1099, // {10}
MIN_REDUCTION+82, // (default reduction)
  }
,
{ // state 901
2,315, // ws*
  }
,
{ // state 902
22,MIN_REDUCTION+59, // `[
107,MIN_REDUCTION+59, // "["
MIN_REDUCTION+59, // (default reduction)
  }
,
{ // state 903
2,316, // ws*
  }
,
{ // state 904
22,MIN_REDUCTION+150, // `[
107,MIN_REDUCTION+150, // "["
MIN_REDUCTION+150, // (default reduction)
  }
,
{ // state 905
MIN_REDUCTION+46, // (default reduction)
  }
,
{ // state 906
2,913, // ws*
22,MIN_REDUCTION+87, // `[
91,1140, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+87, // "["
MIN_REDUCTION+87, // (default reduction)
  }
,
{ // state 907
22,MIN_REDUCTION+150, // `[
107,MIN_REDUCTION+150, // "["
MIN_REDUCTION+150, // (default reduction)
  }
,
{ // state 908
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 909
MIN_REDUCTION+46, // (default reduction)
  }
,
{ // state 910
22,MIN_REDUCTION+154, // `[
107,MIN_REDUCTION+154, // "["
MIN_REDUCTION+154, // (default reduction)
  }
,
{ // state 911
7,1111, // ID
15,771, // `(
49,801, // `+
50,719, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 912
2,391, // ws*
  }
,
{ // state 913
0x80000000|1, // match move
0x80000000|931, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 914
7,1115, // ID
15,774, // `(
49,799, // `+
50,413, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 915
MIN_REDUCTION+22, // (default reduction)
  }
,
{ // state 916
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 917
7,1213, // ID
15,737, // `(
31,19, // <expr>
35,1166, // <expr8>
37,74, // <expr7>
39,90, // <expr6>
41,111, // <expr5>
44,947, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 918
22,MIN_REDUCTION+150, // `[
107,MIN_REDUCTION+150, // "["
MIN_REDUCTION+150, // (default reduction)
  }
,
{ // state 919
0x80000000|517, // match move
0x80000000|25, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 920
MIN_REDUCTION+46, // (default reduction)
  }
,
{ // state 921
7,1213, // ID
15,737, // `(
31,20, // <expr>
35,1166, // <expr8>
37,74, // <expr7>
39,90, // <expr6>
41,111, // <expr5>
44,947, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 922
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 923
22,MIN_REDUCTION+57, // `[
107,MIN_REDUCTION+57, // "["
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 924
22,MIN_REDUCTION+57, // `[
107,MIN_REDUCTION+57, // "["
MIN_REDUCTION+57, // (default reduction)
  }
,
{ // state 925
MIN_REDUCTION+138, // (default reduction)
  }
,
{ // state 926
2,197, // ws*
91,499, // ws
92,1310, // " "
93,1054, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 927
74,595, // "o"
75,128, // "r"
  }
,
{ // state 928
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 929
22,MIN_REDUCTION+161, // `[
107,MIN_REDUCTION+161, // "["
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 930
22,MIN_REDUCTION+161, // `[
107,MIN_REDUCTION+161, // "["
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 931
22,MIN_REDUCTION+86, // `[
91,680, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+86, // "["
MIN_REDUCTION+86, // (default reduction)
  }
,
{ // state 932
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 933
2,MIN_REDUCTION+160, // ws*
92,MIN_REDUCTION+160, // " "
93,MIN_REDUCTION+160, // {10}
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 934
7,1111, // ID
15,771, // `(
31,1340, // <expr>
35,1124, // <expr8>
37,100, // <expr7>
39,103, // <expr6>
41,1372, // <expr5>
44,830, // <expr4>
49,801, // `+
50,723, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 935
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 936
91,383, // ws
92,556, // " "
93,53, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 937
40,791, // `==
42,790, // `!=
97,666, // "@"
MIN_REDUCTION+30, // (default reduction)
  }
,
{ // state 938
8,1119, // `{
103,1167, // "{"
  }
,
{ // state 939
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 940
15,1086, // `(
101,1098, // "("
  }
,
{ // state 941
86,1105, // digit
87,1153, // {"1".."9"}
88,1153, // "0"
89,360, // digit128
90,710, // {176..185}
118,587, // $$1
  }
,
{ // state 942
2,280, // ws*
91,1037, // ws
92,1047, // " "
93,821, // {10}
MIN_REDUCTION+121, // (default reduction)
  }
,
{ // state 943
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 944
MIN_REDUCTION+26, // (default reduction)
  }
,
{ // state 945
3,1368, // <program>
4,465, // <class decl>+
5,1145, // <class decl>
6,1150, // `class
91,326, // ws
92,872, // " "
93,752, // {10}
94,224, // "#"
  }
,
{ // state 946
22,MIN_REDUCTION+161, // `[
107,MIN_REDUCTION+161, // "["
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 947
49,868, // `+
51,887, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+40, // (default reduction)
  }
,
{ // state 948
2,1062, // ws*
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 949
91,611, // ws
92,473, // " "
93,1220, // {10}
MIN_REDUCTION+108, // (default reduction)
  }
,
{ // state 950
86,1105, // digit
87,1153, // {"1".."9"}
88,1153, // "0"
89,231, // digit128
90,629, // {176..185}
118,566, // $$1
  }
,
{ // state 951
0x80000000|1378, // match move
0x80000000|600, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 952
2,150, // ws*
91,499, // ws
92,1310, // " "
93,1054, // {10}
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 953
86,1105, // digit
87,1153, // {"1".."9"}
88,1153, // "0"
89,215, // digit128
90,631, // {176..185}
118,571, // $$1
  }
,
{ // state 954
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 955
7,1195, // ID
8,1204, // `{
15,774, // `(
18,1367, // <type>
19,704, // `int
20,820, // `boolean
24,95, // <stmt>
25,1001, // <assign>
27,1152, // `break
28,543, // `++
29,1052, // `--
30,1242, // `if
31,425, // <expr>
33,445, // <local var decl>
35,1130, // <expr8>
37,124, // <expr7>
39,116, // <expr6>
41,1361, // <expr5>
44,836, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,313, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1185, // letter128
84,422, // {199..218 231..250}
85,422, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,1068, // "#"
95,50, // "+"
96,1186, // "!"
97,331, // "@"
101,1067, // "("
103,527, // "{"
105,205, // "-"
  }
,
{ // state 956
0x80000000|203, // match move
0x80000000|451, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 957
0x80000000|1, // match move
0x80000000|635, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 958
40,776, // `==
42,754, // `!=
97,666, // "@"
MIN_REDUCTION+30, // (default reduction)
  }
,
{ // state 959
0x80000000|427, // match move
0x80000000|13, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 960
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 961
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 962
40,779, // `==
42,753, // `!=
97,666, // "@"
MIN_REDUCTION+30, // (default reduction)
  }
,
{ // state 963
0x80000000|509, // match move
0x80000000|1296, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 964
69,641, // "v"
  }
,
{ // state 965
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 966
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 967
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 968
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 969
91,388, // ws
92,1209, // " "
93,1306, // {10}
MIN_REDUCTION+106, // (default reduction)
  }
,
{ // state 970
0x80000000|1, // match move
0x80000000|800, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 971
2,114, // ws*
  }
,
{ // state 972
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 973
26,1298, // `;
113,1244, // ";"
  }
,
{ // state 974
22,MIN_REDUCTION+161, // `[
107,MIN_REDUCTION+161, // "["
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 975
91,169, // ws
92,1074, // " "
93,1290, // {10}
MIN_REDUCTION+128, // (default reduction)
  }
,
{ // state 976
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 977
91,362, // ws
92,627, // " "
93,67, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 978
0x80000000|1, // match move
0x80000000|808, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 979
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 980
91,1092, // ws
92,1225, // " "
93,1097, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 981
91,372, // ws
92,620, // " "
93,73, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 982
0x80000000|925, // match move
0x80000000|1028, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 983
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 984
22,MIN_REDUCTION+124, // `[
91,722, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+124, // "["
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 985
MIN_REDUCTION+54, // (default reduction)
  }
,
{ // state 986
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,221, // letter128
84,1135, // {199..218 231..250}
85,1135, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1236, // digit128
90,452, // {176..185}
116,1360, // $$0
121,1318, // idChar
122,1272, // "_"
123,1043, // idChar128
124,368, // {223}
  }
,
{ // state 987
91,614, // ws
92,424, // " "
93,1108, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 988
2,1147, // ws*
  }
,
{ // state 989
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 990
22,MIN_REDUCTION+60, // `[
107,MIN_REDUCTION+60, // "["
MIN_REDUCTION+60, // (default reduction)
  }
,
{ // state 991
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 992
22,MIN_REDUCTION+176, // `[
107,MIN_REDUCTION+176, // "["
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 993
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 994
2,14, // ws*
22,MIN_REDUCTION+179, // `[
91,1200, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+179, // "["
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 995
22,MIN_REDUCTION+151, // `[
107,MIN_REDUCTION+151, // "["
MIN_REDUCTION+151, // (default reduction)
  }
,
{ // state 996
91,MIN_REDUCTION+177, // ws
92,MIN_REDUCTION+177, // " "
93,MIN_REDUCTION+177, // {10}
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 997
91,565, // ws
92,405, // " "
93,1110, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 998
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 999
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,221, // letter128
84,1135, // {199..218 231..250}
85,1135, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1236, // digit128
90,452, // {176..185}
115,986, // idChar*
116,456, // $$0
121,301, // idChar
122,1272, // "_"
123,1043, // idChar128
124,368, // {223}
  }
,
{ // state 1000
2,9, // ws*
22,MIN_REDUCTION+179, // `[
91,1201, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+179, // "["
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 1001
26,290, // `;
113,191, // ";"
  }
,
{ // state 1002
2,1356, // ws*
22,MIN_REDUCTION+89, // `[
91,1140, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+89, // "["
MIN_REDUCTION+89, // (default reduction)
  }
,
{ // state 1003
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1004
2,38, // ws*
91,1053, // ws
92,764, // " "
93,855, // {10}
MIN_REDUCTION+103, // (default reduction)
  }
,
{ // state 1005
22,MIN_REDUCTION+60, // `[
107,MIN_REDUCTION+60, // "["
MIN_REDUCTION+60, // (default reduction)
  }
,
{ // state 1006
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 1007
2,749, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 1008
22,MIN_REDUCTION+149, // `[
107,MIN_REDUCTION+149, // "["
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 1009
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 1010
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 1011
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1012
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1013
91,335, // ws
92,609, // " "
93,41, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 1014
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 1015
22,MIN_REDUCTION+124, // `[
91,708, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+124, // "["
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 1016
22,MIN_REDUCTION+124, // `[
91,701, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+124, // "["
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 1017
22,MIN_REDUCTION+163, // `[
107,MIN_REDUCTION+163, // "["
MIN_REDUCTION+163, // (default reduction)
  }
,
{ // state 1018
91,594, // ws
92,447, // " "
93,1084, // {10}
MIN_REDUCTION+122, // (default reduction)
  }
,
{ // state 1019
2,60, // ws*
22,MIN_REDUCTION+179, // `[
91,1164, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+179, // "["
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 1020
0x80000000|203, // match move
0x80000000|356, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1021
MIN_REDUCTION+24, // (default reduction)
  }
,
{ // state 1022
22,MIN_REDUCTION+151, // `[
107,MIN_REDUCTION+151, // "["
MIN_REDUCTION+151, // (default reduction)
  }
,
{ // state 1023
22,MIN_REDUCTION+60, // `[
107,MIN_REDUCTION+60, // "["
MIN_REDUCTION+60, // (default reduction)
  }
,
{ // state 1024
16,1325, // `)
21,46, // <empty bracket pair>
22,1391, // `[
102,1090, // ")"
107,1202, // "["
  }
,
{ // state 1025
7,1093, // ID
18,417, // <type>
19,1085, // `int
20,1284, // `boolean
66,237, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,748, // letter128
84,1071, // {199..218 231..250}
85,1071, // {193..198 225..230}
94,1156, // "#"
  }
,
{ // state 1026
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 1027
22,MIN_REDUCTION+151, // `[
107,MIN_REDUCTION+151, // "["
MIN_REDUCTION+151, // (default reduction)
  }
,
{ // state 1028
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+138, // (default reduction)
  }
,
{ // state 1029
22,MIN_REDUCTION+148, // `[
107,MIN_REDUCTION+148, // "["
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 1030
128,MIN_REDUCTION+68, // $NT
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1031
0x80000000|1, // match move
0x80000000|286, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1032
76,644, // "u"
  }
,
{ // state 1033
22,MIN_REDUCTION+149, // `[
107,MIN_REDUCTION+149, // "["
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 1034
16,755, // `)
102,664, // ")"
  }
,
{ // state 1035
22,MIN_REDUCTION+149, // `[
107,MIN_REDUCTION+149, // "["
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 1036
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 1037
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 1038
7,1213, // ID
15,737, // `(
44,1169, // <expr4>
49,770, // `+
50,86, // <expr3>
51,216, // `-
53,513, // <expr2>
56,862, // <cast expr>
57,442, // <expr1>
58,1252, // <unary expr>
59,188, // `!
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 1039
2,1062, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 1040
22,MIN_REDUCTION+86, // `[
91,701, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+86, // "["
MIN_REDUCTION+86, // (default reduction)
  }
,
{ // state 1041
2,1362, // ws*
22,MIN_REDUCTION+179, // `[
91,1140, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+179, // "["
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 1042
76,657, // "u"
  }
,
{ // state 1043
0x80000000|692, // match move
0x80000000|1007, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1044
2,1315, // ws*
22,MIN_REDUCTION+89, // `[
91,1201, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+89, // "["
MIN_REDUCTION+89, // (default reduction)
  }
,
{ // state 1045
22,MIN_REDUCTION+86, // `[
91,708, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+86, // "["
MIN_REDUCTION+86, // (default reduction)
  }
,
{ // state 1046
2,1317, // ws*
22,MIN_REDUCTION+89, // `[
91,1200, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+89, // "["
MIN_REDUCTION+89, // (default reduction)
  }
,
{ // state 1047
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1048
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 1049
0x80000000|948, // match move
0x80000000|1039, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1050
22,MIN_REDUCTION+151, // `[
107,MIN_REDUCTION+151, // "["
MIN_REDUCTION+151, // (default reduction)
  }
,
{ // state 1051
2,1356, // ws*
  }
,
{ // state 1052
7,201, // ID
66,1382, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1261, // letter128
84,896, // {199..218 231..250}
85,896, // {193..198 225..230}
  }
,
{ // state 1053
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 1054
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1055
7,1111, // ID
15,771, // `(
44,222, // <expr4>
49,801, // `+
50,723, // <expr3>
51,258, // `-
53,525, // <expr2>
56,838, // <cast expr>
57,674, // <expr1>
58,1230, // <unary expr>
59,162, // `!
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 1056
7,1115, // ID
15,774, // `(
44,293, // <expr4>
49,799, // `+
50,716, // <expr3>
51,248, // `-
53,530, // <expr2>
56,840, // <cast expr>
57,658, // <expr1>
58,1231, // <unary expr>
59,161, // `!
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 1057
7,267, // ID
66,648, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1241, // letter128
84,1083, // {199..218 231..250}
85,1083, // {193..198 225..230}
  }
,
{ // state 1058
76,729, // "u"
  }
,
{ // state 1059
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1060
40,805, // `==
42,736, // `!=
97,666, // "@"
MIN_REDUCTION+30, // (default reduction)
  }
,
{ // state 1061
16,254, // `)
102,664, // ")"
  }
,
{ // state 1062
0x80000000|1282, // match move
0x80000000|433, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1063
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 1064
22,MIN_REDUCTION+124, // `[
91,680, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+124, // "["
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 1065
22,MIN_REDUCTION+60, // `[
107,MIN_REDUCTION+60, // "["
MIN_REDUCTION+60, // (default reduction)
  }
,
{ // state 1066
22,MIN_REDUCTION+86, // `[
91,722, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+86, // "["
MIN_REDUCTION+86, // (default reduction)
  }
};
}
private class Initter4{
public int doInit(int startIdx) {
  for (int i = 0; i < myParseTable.length; i++) {
    parseTable[i+startIdx] = myParseTable[i];
  }
  return myParseTable.length;
}
private final int[][] myParseTable = {
{ // state 1067
2,969, // ws*
91,603, // ws
92,1209, // " "
93,1306, // {10}
MIN_REDUCTION+107, // (default reduction)
  }
,
{ // state 1068
71,870, // "f"
72,508, // "i"
77,927, // "b"
81,1032, // "n"
82,1376, // "t"
95,679, // "+"
  }
,
{ // state 1069
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 1070
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 1071
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 1072
16,1303, // `)
21,46, // <empty bracket pair>
22,1391, // `[
102,1090, // ")"
107,1202, // "["
  }
,
{ // state 1073
7,1103, // ID
15,1025, // `(
44,238, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 1074
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1075
2,1317, // ws*
  }
,
{ // state 1076
16,1277, // `)
21,46, // <empty bracket pair>
22,1391, // `[
102,1090, // ")"
107,1202, // "["
  }
,
{ // state 1077
2,1315, // ws*
  }
,
{ // state 1078
22,MIN_REDUCTION+149, // `[
107,MIN_REDUCTION+149, // "["
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 1079
2,778, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+139, // (default reduction)
  }
,
{ // state 1080
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 1081
MIN_REDUCTION+23, // (default reduction)
  }
,
{ // state 1082
22,MIN_REDUCTION+148, // `[
107,MIN_REDUCTION+148, // "["
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 1083
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 1084
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1085
MIN_REDUCTION+9, // (default reduction)
  }
,
{ // state 1086
7,1103, // ID
15,1025, // `(
31,589, // <expr>
35,1107, // <expr8>
37,174, // <expr7>
39,155, // <expr6>
41,1266, // <expr5>
44,772, // <expr4>
49,745, // `+
50,686, // <expr3>
51,244, // `-
53,536, // <expr2>
56,817, // <cast expr>
57,711, // <expr1>
58,1250, // <unary expr>
59,30, // `!
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
95,50, // "+"
96,1186, // "!"
101,1067, // "("
105,205, // "-"
  }
,
{ // state 1087
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 1088
22,MIN_REDUCTION+155, // `[
107,MIN_REDUCTION+155, // "["
MIN_REDUCTION+155, // (default reduction)
  }
,
{ // state 1089
91,335, // ws
92,609, // " "
93,41, // {10}
MIN_REDUCTION+70, // (default reduction)
  }
,
{ // state 1090
2,617, // ws*
91,601, // ws
92,763, // " "
93,726, // {10}
MIN_REDUCTION+109, // (default reduction)
  }
,
{ // state 1091
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 1092
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 1093
MIN_REDUCTION+11, // (default reduction)
  }
,
{ // state 1094
0x80000000|1222, // match move
0x80000000|725, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1095
26,1298, // `;
113,34, // ";"
  }
,
{ // state 1096
49,807, // `+
51,895, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+36, // (default reduction)
  }
,
{ // state 1097
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1098
2,394, // ws*
91,1138, // ws
92,147, // " "
93,43, // {10}
MIN_REDUCTION+107, // (default reduction)
  }
,
{ // state 1099
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1100
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 1101
MIN_REDUCTION+14, // (default reduction)
  }
,
{ // state 1102
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 1103
0x80000000|1, // match move
0x80000000|894, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1104
2,461, // ws*
91,435, // ws
92,746, // " "
93,793, // {10}
MIN_REDUCTION+81, // (default reduction)
  }
,
{ // state 1105
MIN_REDUCTION+164, // (default reduction)
  }
,
{ // state 1106
22,MIN_REDUCTION+155, // `[
107,MIN_REDUCTION+155, // "["
MIN_REDUCTION+155, // (default reduction)
  }
,
{ // state 1107
36,117, // `||
97,1302, // "@"
MIN_REDUCTION+27, // (default reduction)
  }
,
{ // state 1108
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1109
2,677, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 1110
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1111
0x80000000|1, // match move
0x80000000|923, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1112
MIN_REDUCTION+15, // (default reduction)
  }
,
{ // state 1113
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1114
2,275, // ws*
22,MIN_REDUCTION+91, // `[
91,1140, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+91, // "["
MIN_REDUCTION+91, // (default reduction)
  }
,
{ // state 1115
0x80000000|1, // match move
0x80000000|924, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1116
MIN_REDUCTION+18, // (default reduction)
  }
,
{ // state 1117
22,MIN_REDUCTION+155, // `[
107,MIN_REDUCTION+155, // "["
MIN_REDUCTION+155, // (default reduction)
  }
,
{ // state 1118
22,MIN_REDUCTION+61, // `[
107,MIN_REDUCTION+61, // "["
MIN_REDUCTION+61, // (default reduction)
  }
,
{ // state 1119
9,685, // <decl in class>*
10,1197, // `}
11,395, // <decl in class>
12,261, // <method decl>
13,1312, // `public
94,1243, // "#"
104,876, // "}"
  }
,
{ // state 1120
91,148, // ws
92,1047, // " "
93,821, // {10}
MIN_REDUCTION+98, // (default reduction)
  }
,
{ // state 1121
2,156, // ws*
22,MIN_REDUCTION+85, // `[
91,1201, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+85, // "["
MIN_REDUCTION+85, // (default reduction)
  }
,
{ // state 1122
52,675, // `*
54,345, // `/
55,493, // `%
98,467, // "%"
100,479, // "*"
114,1299, // "/"
MIN_REDUCTION+41, // (default reduction)
  }
,
{ // state 1123
2,158, // ws*
22,MIN_REDUCTION+85, // `[
91,1200, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+85, // "["
MIN_REDUCTION+85, // (default reduction)
  }
,
{ // state 1124
36,102, // `||
97,1302, // "@"
MIN_REDUCTION+27, // (default reduction)
  }
,
{ // state 1125
MIN_REDUCTION+23, // (default reduction)
  }
,
{ // state 1126
MIN_REDUCTION+162, // (default reduction)
  }
,
{ // state 1127
0x80000000|1, // match move
0x80000000|247, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1128
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 1129
22,MIN_REDUCTION+61, // `[
107,MIN_REDUCTION+61, // "["
MIN_REDUCTION+61, // (default reduction)
  }
,
{ // state 1130
36,106, // `||
97,1302, // "@"
MIN_REDUCTION+27, // (default reduction)
  }
,
{ // state 1131
91,1092, // ws
92,1225, // " "
93,1097, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 1132
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,6, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,851, // digit128
90,710, // {176..185}
116,605, // $$0
121,1318, // idChar
122,1272, // "_"
123,330, // idChar128
124,398, // {223}
  }
,
{ // state 1133
2,677, // ws*
MIN_REDUCTION+113, // (default reduction)
  }
,
{ // state 1134
91,568, // ws
92,746, // " "
93,793, // {10}
MIN_REDUCTION+108, // (default reduction)
  }
,
{ // state 1135
0x80000000|897, // match move
0x80000000|366, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1136
91,516, // ws
92,1030, // " "
93,1322, // {10}
128,MIN_REDUCTION+124, // $NT
  }
,
{ // state 1137
22,MIN_REDUCTION+61, // `[
107,MIN_REDUCTION+61, // "["
MIN_REDUCTION+61, // (default reduction)
  }
,
{ // state 1138
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 1139
91,196, // ws
92,991, // " "
93,1274, // {10}
MIN_REDUCTION+116, // (default reduction)
  }
,
{ // state 1140
0x80000000|1, // match move
0x80000000|299, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1141
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 1142
22,MIN_REDUCTION+58, // `[
107,MIN_REDUCTION+58, // "["
MIN_REDUCTION+58, // (default reduction)
  }
,
{ // state 1143
2,1120, // ws*
91,1037, // ws
92,1047, // " "
93,821, // {10}
MIN_REDUCTION+99, // (default reduction)
  }
,
{ // state 1144
2,172, // ws*
22,MIN_REDUCTION+85, // `[
91,1164, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+85, // "["
MIN_REDUCTION+85, // (default reduction)
  }
,
{ // state 1145
MIN_REDUCTION+174, // (default reduction)
  }
,
{ // state 1146
22,MIN_REDUCTION+148, // `[
107,MIN_REDUCTION+148, // "["
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 1147
0x80000000|1, // match move
0x80000000|1246, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1148
22,MIN_REDUCTION+148, // `[
107,MIN_REDUCTION+148, // "["
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 1149
91,91, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 1150
7,938, // ID
66,472, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1363, // letter128
84,1157, // {199..218 231..250}
85,1157, // {193..198 225..230}
  }
,
{ // state 1151
91,1287, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 1152
26,1112, // `;
113,191, // ";"
  }
,
{ // state 1153
MIN_REDUCTION+66, // (default reduction)
  }
,
{ // state 1154
26,1184, // `;
113,1244, // ";"
  }
,
{ // state 1155
-1, // $$start
-1, // <start>
-1, // ws*
-1, // <program>
-1, // <class decl>+
-1, // <class decl>
-1, // `class
1195, // ID
1204, // `{
-1, // <decl in class>*
915, // `}
-1, // <decl in class>
-1, // <method decl>
-1, // `public
-1, // `void
774, // `(
-1, // `)
-1, // <stmt>*
1367, // <type>
704, // `int
820, // `boolean
-1, // <empty bracket pair>
-1, // `[
-1, // `]
877, // <stmt>
1001, // <assign>
-1, // `;
1152, // `break
543, // `++
1052, // `--
1242, // `if
425, // <expr>
-1, // `else
445, // <local var decl>
-1, // `=
1130, // <expr8>
-1, // `||
124, // <expr7>
-1, // `&&
116, // <expr6>
-1, // `==
1361, // <expr5>
-1, // `!=
-1, // `<
836, // <expr4>
-1, // `>
-1, // `<=
-1, // `>=
-1, // `instanceof
799, // `+
716, // <expr3>
248, // `-
-1, // `*
530, // <expr2>
-1, // `/
-1, // `%
840, // <cast expr>
658, // <expr1>
1231, // <unary expr>
161, // `!
-1, // `.
49, // INTLIT
65, // `true
747, // `false
1182, // `null
429, // `this
313, // letter
848, // "a"
848, // "p"
848, // "v"
848, // "c"
848, // "f"
848, // "i"
848, // "l"
848, // "o"
848, // "r"
848, // "u"
848, // "b"
848, // "e"
848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
848, // "h"
848, // "n"
848, // "t"
1185, // letter128
422, // {199..218 231..250}
422, // {193..198 225..230}
-1, // digit
380, // {"1".."9"}
504, // "0"
787, // digit128
631, // {176..185}
-1, // ws
-1, // " "
-1, // {10}
1068, // "#"
50, // "+"
1186, // "!"
331, // "@"
-1, // "%"
-1, // "&"
-1, // "*"
1067, // "("
-1, // ")"
527, // "{"
857, // "}"
205, // "-"
-1, // "="
-1, // "["
-1, // "]"
-1, // "|"
-1, // "<"
-1, // ">"
-1, // "."
-1, // ";"
-1, // "/"
-1, // idChar*
-1, // $$0
-1, // digit*
-1, // $$1
-1, // hexDigit*
-1, // $$2
-1, // idChar
-1, // "_"
-1, // idChar128
-1, // {223}
-1, // hexDigit
-1, // hexDigit128
-1, // $
-1, // $NT
  }
,
{ // state 1156
72,58, // "i"
77,303, // "b"
  }
,
{ // state 1157
MIN_REDUCTION+65, // (default reduction)
  }
,
{ // state 1158
22,MIN_REDUCTION+61, // `[
107,MIN_REDUCTION+61, // "["
MIN_REDUCTION+61, // (default reduction)
  }
,
{ // state 1159
22,MIN_REDUCTION+148, // `[
107,MIN_REDUCTION+148, // "["
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 1160
49,845, // `+
51,911, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+36, // (default reduction)
  }
,
{ // state 1161
49,844, // `+
51,914, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+36, // (default reduction)
  }
,
{ // state 1162
MIN_REDUCTION+171, // (default reduction)
  }
,
{ // state 1163
2,156, // ws*
  }
,
{ // state 1164
0x80000000|1, // match move
0x80000000|137, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1165
2,158, // ws*
  }
,
{ // state 1166
36,130, // `||
97,1302, // "@"
MIN_REDUCTION+27, // (default reduction)
  }
,
{ // state 1167
2,45, // ws*
91,618, // ws
92,1003, // " "
93,705, // {10}
MIN_REDUCTION+111, // (default reduction)
  }
,
{ // state 1168
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 1169
49,868, // `+
51,887, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+35, // (default reduction)
  }
,
{ // state 1170
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 1171
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,64, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,919, // digit128
90,673, // {176..185}
116,653, // $$0
121,1318, // idChar
122,1272, // "_"
123,57, // idChar128
124,531, // {223}
  }
,
{ // state 1172
0x80000000|462, // match move
0x80000000|485, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1173
23,768, // `]
108,561, // "]"
  }
,
{ // state 1174
0x80000000|496, // match move
0x80000000|992, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1175
0x80000000|1, // match move
0x80000000|171, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1176
2,1151, // ws*
91,1292, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+143, // (default reduction)
  }
,
{ // state 1177
49,868, // `+
51,887, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+36, // (default reduction)
  }
,
{ // state 1178
2,172, // ws*
  }
,
{ // state 1179
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 1180
91,335, // ws
92,609, // " "
93,41, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 1181
2,283, // ws*
  }
,
{ // state 1182
0x80000000|1, // match move
0x80000000|211, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1183
0x80000000|1, // match move
0x80000000|217, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1184
0x80000000|454, // match move
0x80000000|819, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1185
0x80000000|317, // match move
0x80000000|1216, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1186
2,797, // ws*
91,1100, // ws
92,82, // " "
93,179, // {10}
MIN_REDUCTION+97, // (default reduction)
  }
,
{ // state 1187
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,475, // letter128
84,422, // {199..218 231..250}
85,422, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,841, // digit128
90,766, // {176..185}
116,154, // $$0
121,1318, // idChar
122,1272, // "_"
123,71, // idChar128
124,839, // {223}
  }
,
{ // state 1188
91,196, // ws
92,991, // " "
93,1274, // {10}
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 1189
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 1190
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 1191
91,383, // ws
92,556, // " "
93,53, // {10}
MIN_REDUCTION+70, // (default reduction)
  }
,
{ // state 1192
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 1193
91,1092, // ws
92,1225, // " "
93,1097, // {10}
MIN_REDUCTION+124, // (default reduction)
  }
,
{ // state 1194
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,28, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,827, // digit128
90,629, // {176..185}
116,681, // $$0
121,1318, // idChar
122,1272, // "_"
123,88, // idChar128
124,541, // {223}
  }
,
{ // state 1195
0x80000000|203, // match move
0x80000000|497, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1196
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,29, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,823, // digit128
90,631, // {176..185}
116,684, // $$0
121,1318, // idChar
122,1272, // "_"
123,84, // idChar128
124,535, // {223}
  }
,
{ // state 1197
MIN_REDUCTION+5, // (default reduction)
  }
,
{ // state 1198
MIN_REDUCTION+142, // (default reduction)
  }
,
{ // state 1199
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 1200
0x80000000|1, // match move
0x80000000|122, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1201
0x80000000|1, // match move
0x80000000|121, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1202
2,1018, // ws*
91,352, // ws
92,447, // " "
93,1084, // {10}
MIN_REDUCTION+123, // (default reduction)
  }
,
{ // state 1203
0x80000000|266, // match move
0x80000000|13, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1204
-1, // $$start
-1, // <start>
-1, // ws*
-1, // <program>
-1, // <class decl>+
-1, // <class decl>
-1, // `class
1195, // ID
1204, // `{
-1, // <decl in class>*
1125, // `}
-1, // <decl in class>
-1, // <method decl>
-1, // `public
-1, // `void
774, // `(
-1, // `)
1155, // <stmt>*
1367, // <type>
704, // `int
820, // `boolean
-1, // <empty bracket pair>
-1, // `[
-1, // `]
1162, // <stmt>
1001, // <assign>
-1, // `;
1152, // `break
543, // `++
1052, // `--
1242, // `if
425, // <expr>
-1, // `else
445, // <local var decl>
-1, // `=
1130, // <expr8>
-1, // `||
124, // <expr7>
-1, // `&&
116, // <expr6>
-1, // `==
1361, // <expr5>
-1, // `!=
-1, // `<
836, // <expr4>
-1, // `>
-1, // `<=
-1, // `>=
-1, // `instanceof
799, // `+
716, // <expr3>
248, // `-
-1, // `*
530, // <expr2>
-1, // `/
-1, // `%
840, // <cast expr>
658, // <expr1>
1231, // <unary expr>
161, // `!
-1, // `.
49, // INTLIT
65, // `true
747, // `false
1182, // `null
429, // `this
313, // letter
848, // "a"
848, // "p"
848, // "v"
848, // "c"
848, // "f"
848, // "i"
848, // "l"
848, // "o"
848, // "r"
848, // "u"
848, // "b"
848, // "e"
848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
848, // "h"
848, // "n"
848, // "t"
1185, // letter128
422, // {199..218 231..250}
422, // {193..198 225..230}
-1, // digit
380, // {"1".."9"}
504, // "0"
787, // digit128
631, // {176..185}
-1, // ws
-1, // " "
-1, // {10}
1068, // "#"
50, // "+"
1186, // "!"
331, // "@"
-1, // "%"
-1, // "&"
-1, // "*"
1067, // "("
-1, // ")"
527, // "{"
857, // "}"
205, // "-"
-1, // "="
-1, // "["
-1, // "]"
-1, // "|"
-1, // "<"
-1, // ">"
-1, // "."
-1, // ";"
-1, // "/"
-1, // idChar*
-1, // $$0
-1, // digit*
-1, // $$1
-1, // hexDigit*
-1, // $$2
-1, // idChar
-1, // "_"
-1, // idChar128
-1, // {223}
-1, // hexDigit
-1, // hexDigit128
-1, // $
-1, // $NT
  }
,
{ // state 1205
0x80000000|1335, // match move
0x80000000|92, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1206
2,277, // ws*
  }
,
{ // state 1207
7,444, // ID
66,439, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,246, // letter128
84,1135, // {199..218 231..250}
85,1135, // {193..198 225..230}
  }
,
{ // state 1208
2,281, // ws*
  }
,
{ // state 1209
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1210
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 1211
91,MIN_REDUCTION+69, // ws
92,MIN_REDUCTION+69, // " "
93,MIN_REDUCTION+69, // {10}
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1212
91,372, // ws
92,620, // " "
93,73, // {10}
MIN_REDUCTION+70, // (default reduction)
  }
,
{ // state 1213
0x80000000|1, // match move
0x80000000|891, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1214
91,362, // ws
92,627, // " "
93,67, // {10}
MIN_REDUCTION+70, // (default reduction)
  }
,
{ // state 1215
22,MIN_REDUCTION+155, // `[
107,MIN_REDUCTION+155, // "["
MIN_REDUCTION+155, // (default reduction)
  }
,
{ // state 1216
2,498, // ws*
22,MIN_REDUCTION+147, // `[
91,816, // ws
92,68, // " "
93,963, // {10}
107,MIN_REDUCTION+147, // "["
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1217
91,567, // ws
92,403, // " "
93,1113, // {10}
MIN_REDUCTION+106, // (default reduction)
  }
,
{ // state 1218
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1219
0x80000000|186, // match move
0x80000000|364, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1220
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1221
91,1048, // ws
92,147, // " "
93,43, // {10}
MIN_REDUCTION+122, // (default reduction)
  }
,
{ // state 1222
2,320, // ws*
  }
,
{ // state 1223
0x80000000|236, // match move
0x80000000|1343, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1224
91,611, // ws
92,473, // " "
93,1220, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 1225
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1226
MIN_REDUCTION+159, // (default reduction)
  }
,
{ // state 1227
2,114, // ws*
22,MIN_REDUCTION+85, // `[
91,1140, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+85, // "["
MIN_REDUCTION+85, // (default reduction)
  }
,
{ // state 1228
22,MIN_REDUCTION+88, // `[
91,680, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+88, // "["
MIN_REDUCTION+88, // (default reduction)
  }
,
{ // state 1229
74,721, // "o"
  }
,
{ // state 1230
MIN_REDUCTION+51, // (default reduction)
  }
,
{ // state 1231
MIN_REDUCTION+51, // (default reduction)
  }
,
{ // state 1232
91,1048, // ws
92,147, // " "
93,43, // {10}
MIN_REDUCTION+118, // (default reduction)
  }
,
{ // state 1233
81,660, // "n"
  }
,
{ // state 1234
2,810, // ws*
  }
,
{ // state 1235
2,253, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1236
0x80000000|581, // match move
0x80000000|933, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1237
2,951, // ws*
MIN_REDUCTION+179, // (default reduction)
  }
,
{ // state 1238
2,742, // ws*
  }
,
{ // state 1239
22,MIN_REDUCTION+149, // `[
107,MIN_REDUCTION+149, // "["
MIN_REDUCTION+149, // (default reduction)
  }
,
{ // state 1240
2,761, // ws*
  }
,
{ // state 1241
2,997, // ws*
91,17, // ws
92,405, // " "
93,1110, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1242
15,455, // `(
101,1098, // "("
  }
,
{ // state 1243
68,131, // "p"
  }
,
{ // state 1244
0x80000000|593, // match move
0x80000000|1079, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1245
MIN_REDUCTION+169, // (default reduction)
  }
,
{ // state 1246
22,MIN_REDUCTION+88, // `[
91,722, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+88, // "["
MIN_REDUCTION+88, // (default reduction)
  }
,
{ // state 1247
7,1103, // ID
15,1025, // `(
56,1379, // <cast expr>
57,1031, // <expr1>
61,39, // INTLIT
62,80, // `true
63,765, // `false
64,1175, // `null
65,420, // `this
66,263, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,624, // letter128
84,1330, // {199..218 231..250}
85,1330, // {193..198 225..230}
87,350, // {"1".."9"}
88,297, // "0"
89,815, // digit128
90,673, // {176..185}
94,26, // "#"
101,1067, // "("
  }
,
{ // state 1248
91,580, // ws
92,82, // " "
93,179, // {10}
MIN_REDUCTION+116, // (default reduction)
  }
,
{ // state 1249
91,835, // ws
92,760, // " "
93,89, // {10}
MIN_REDUCTION+110, // (default reduction)
  }
,
{ // state 1250
MIN_REDUCTION+51, // (default reduction)
  }
,
{ // state 1251
22,MIN_REDUCTION+182, // `[
91,701, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+182, // "["
MIN_REDUCTION+182, // (default reduction)
  }
,
{ // state 1252
MIN_REDUCTION+51, // (default reduction)
  }
,
{ // state 1253
2,528, // ws*
22,MIN_REDUCTION+147, // `[
91,1140, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+147, // "["
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1254
2,1362, // ws*
  }
,
{ // state 1255
22,MIN_REDUCTION+182, // `[
91,708, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+182, // "["
MIN_REDUCTION+182, // (default reduction)
  }
,
{ // state 1256
2,762, // ws*
91,1292, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 1257
MIN_REDUCTION+8, // (default reduction)
  }
,
{ // state 1258
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1259
MIN_REDUCTION+148, // (default reduction)
  }
,
{ // state 1260
82,446, // "t"
  }
,
{ // state 1261
2,1308, // ws*
91,1292, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1262
22,MIN_REDUCTION+88, // `[
91,708, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+88, // "["
MIN_REDUCTION+88, // (default reduction)
  }
,
{ // state 1263
MIN_REDUCTION+49, // (default reduction)
  }
,
{ // state 1264
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 1265
22,MIN_REDUCTION+88, // `[
91,701, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+88, // "["
MIN_REDUCTION+88, // (default reduction)
  }
,
{ // state 1266
43,1073, // `<
45,649, // `>
46,141, // `<=
47,145, // `>=
48,194, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+34, // (default reduction)
  }
,
{ // state 1267
0x80000000|453, // match move
0x80000000|1211, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1268
74,672, // "o"
  }
,
{ // state 1269
49,845, // `+
51,911, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+38, // (default reduction)
  }
,
{ // state 1270
2,143, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 1271
MIN_REDUCTION+4, // (default reduction)
  }
,
{ // state 1272
MIN_REDUCTION+158, // (default reduction)
  }
,
{ // state 1273
2,987, // ws*
91,378, // ws
92,424, // " "
93,1108, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1274
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1275
0x80000000|1, // match move
0x80000000|623, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1276
49,844, // `+
51,914, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+38, // (default reduction)
  }
,
{ // state 1277
7,1115, // ID
15,774, // `(
56,1374, // <cast expr>
57,744, // <expr1>
61,49, // INTLIT
62,65, // `true
63,747, // `false
64,1182, // `null
65,429, // `this
66,304, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,602, // letter128
84,1342, // {199..218 231..250}
85,1342, // {193..198 225..230}
87,380, // {"1".."9"}
88,504, // "0"
89,787, // digit128
90,631, // {176..185}
94,347, // "#"
101,1067, // "("
  }
,
{ // state 1278
2,480, // ws*
91,1344, // ws
92,108, // " "
93,1267, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1279
0x80000000|1, // match move
0x80000000|652, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1280
0x80000000|1, // match move
0x80000000|650, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1281
91,383, // ws
92,556, // " "
93,53, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 1282
MIN_REDUCTION+112, // (default reduction)
  }
,
{ // state 1283
74,668, // "o"
  }
,
{ // state 1284
MIN_REDUCTION+10, // (default reduction)
  }
,
{ // state 1285
91,362, // ws
92,627, // " "
93,67, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 1286
2,487, // ws*
22,MIN_REDUCTION+147, // `[
91,1200, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+147, // "["
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1287
MIN_REDUCTION+176, // (default reduction)
  }
,
{ // state 1288
22,MIN_REDUCTION+182, // `[
91,680, // ws
92,340, // " "
93,1305, // {10}
107,MIN_REDUCTION+182, // "["
MIN_REDUCTION+182, // (default reduction)
  }
,
{ // state 1289
2,490, // ws*
22,MIN_REDUCTION+147, // `[
91,1201, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+147, // "["
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1290
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1291
75,341, // "r"
80,738, // "h"
  }
,
{ // state 1292
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 1293
91,125, // ws
92,1011, // " "
93,1258, // {10}
MIN_REDUCTION+104, // (default reduction)
  }
,
{ // state 1294
2,MIN_REDUCTION+67, // ws*
92,MIN_REDUCTION+67, // " "
93,MIN_REDUCTION+67, // {10}
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 1295
MIN_REDUCTION+67, // (default reduction)
  }
,
{ // state 1296
22,MIN_REDUCTION+69, // `[
107,MIN_REDUCTION+69, // "["
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1297
43,1038, // `<
45,443, // `>
46,98, // `<=
47,625, // `>=
48,12, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+32, // (default reduction)
  }
,
{ // state 1298
0x80000000|1101, // match move
0x80000000|78, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1299
2,353, // ws*
91,976, // ws
92,1011, // " "
93,1258, // {10}
MIN_REDUCTION+145, // (default reduction)
  }
,
{ // state 1300
0x80000000|773, // match move
0x80000000|546, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1301
2,913, // ws*
  }
,
{ // state 1302
109,676, // "|"
  }
,
{ // state 1303
7,1111, // ID
15,771, // `(
56,1371, // <cast expr>
57,743, // <expr1>
61,47, // INTLIT
62,63, // `true
63,740, // `false
64,1183, // `null
65,428, // `this
66,287, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,610, // letter128
84,1339, // {199..218 231..250}
85,1339, // {193..198 225..230}
87,386, // {"1".."9"}
88,276, // "0"
89,794, // digit128
90,629, // {176..185}
94,361, // "#"
101,1067, // "("
  }
,
{ // state 1304
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1305
0x80000000|1, // match move
0x80000000|682, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1306
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1307
49,807, // `+
51,895, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+38, // (default reduction)
  }
,
{ // state 1308
91,1287, // ws
92,1059, // " "
93,1350, // {10}
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 1309
74,636, // "o"
  }
,
{ // state 1310
MIN_REDUCTION+68, // (default reduction)
  }
,
{ // state 1311
91,372, // ws
92,620, // " "
93,73, // {10}
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 1312
14,1057, // `void
94,964, // "#"
  }
,
{ // state 1313
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 1314
22,MIN_REDUCTION+58, // `[
107,MIN_REDUCTION+58, // "["
MIN_REDUCTION+58, // (default reduction)
  }
,
{ // state 1315
0x80000000|1, // match move
0x80000000|1265, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1316
22,MIN_REDUCTION+146, // `[
91,1174, // ws
92,68, // " "
93,963, // {10}
107,MIN_REDUCTION+146, // "["
MIN_REDUCTION+146, // (default reduction)
  }
,
{ // state 1317
0x80000000|1, // match move
0x80000000|1262, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1318
MIN_REDUCTION+172, // (default reduction)
  }
,
{ // state 1319
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 1320
0x80000000|1, // match move
0x80000000|910, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1321
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 1322
128,MIN_REDUCTION+69, // $NT
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1323
MIN_REDUCTION+177, // (default reduction)
  }
,
{ // state 1324
22,MIN_REDUCTION+58, // `[
107,MIN_REDUCTION+58, // "["
MIN_REDUCTION+58, // (default reduction)
  }
,
{ // state 1325
7,1213, // ID
15,737, // `(
56,1263, // <cast expr>
57,860, // <expr1>
61,81, // INTLIT
62,142, // `true
63,809, // `false
64,1127, // `null
65,521, // `this
66,343, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,645, // letter128
84,1364, // {199..218 231..250}
85,1364, // {193..198 225..230}
87,242, // {"1".."9"}
88,542, // "0"
89,750, // digit128
90,710, // {176..185}
94,514, // "#"
101,1067, // "("
  }
,
{ // state 1326
0x80000000|1, // match move
0x80000000|1035, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1327
82,720, // "t"
  }
,
{ // state 1328
2,311, // ws*
91,52, // ws
92,1030, // " "
93,1322, // {10}
128,MIN_REDUCTION+81, // $NT
  }
,
{ // state 1329
0x80000000|1, // match move
0x80000000|1033, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1330
0x80000000|399, // match move
0x80000000|359, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1331
8,139, // `{
103,527, // "{"
  }
,
{ // state 1332
91,75, // ws
92,1310, // " "
93,1054, // {10}
MIN_REDUCTION+74, // (default reduction)
  }
,
{ // state 1333
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 1334
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 1335
2,1219, // ws*
MIN_REDUCTION+141, // (default reduction)
  }
,
{ // state 1336
MIN_REDUCTION+12, // (default reduction)
  }
,
{ // state 1337
2,975, // ws*
91,1010, // ws
92,1074, // " "
93,1290, // {10}
MIN_REDUCTION+129, // (default reduction)
  }
,
{ // state 1338
2,391, // ws*
22,MIN_REDUCTION+91, // `[
91,1164, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+91, // "["
MIN_REDUCTION+91, // (default reduction)
  }
,
{ // state 1339
0x80000000|399, // match move
0x80000000|393, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1340
MIN_REDUCTION+25, // (default reduction)
  }
,
{ // state 1341
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 1342
0x80000000|399, // match move
0x80000000|376, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1343
MIN_REDUCTION+22, // (default reduction)
  }
,
{ // state 1344
0x80000000|932, // match move
0x80000000|996, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1345
0x80000000|1, // match move
0x80000000|1008, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1346
0x80000000|1, // match move
0x80000000|822, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1347
0x80000000|1181, // match move
0x80000000|55, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1348
0x80000000|1, // match move
0x80000000|824, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1349
75,363, // "r"
80,811, // "h"
  }
,
{ // state 1350
MIN_REDUCTION+69, // (default reduction)
  }
,
{ // state 1351
43,1038, // `<
45,443, // `>
46,98, // `<=
47,625, // `>=
48,12, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+33, // (default reduction)
  }
,
{ // state 1352
0x80000000|875, // match move
0x80000000|621, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1353
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 1354
2,477, // ws*
22,MIN_REDUCTION+147, // `[
91,1164, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+147, // "["
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1355
22,MIN_REDUCTION+58, // `[
107,MIN_REDUCTION+58, // "["
MIN_REDUCTION+58, // (default reduction)
  }
,
{ // state 1356
0x80000000|1, // match move
0x80000000|1228, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1357
32,198, // `else
94,599, // "#"
  }
,
{ // state 1358
2,9, // ws*
  }
,
{ // state 1359
2,14, // ws*
  }
,
{ // state 1360
0x80000000|935, // match move
0x80000000|850, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1361
43,1056, // `<
45,659, // `>
46,127, // `<=
47,608, // `>=
48,183, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+34, // (default reduction)
  }
,
{ // state 1362
0x80000000|1, // match move
0x80000000|892, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1363
2,1224, // ws*
91,328, // ws
92,473, // " "
93,1220, // {10}
MIN_REDUCTION+147, // (default reduction)
  }
,
{ // state 1364
0x80000000|399, // match move
0x80000000|308, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1365
2,316, // ws*
22,MIN_REDUCTION+91, // `[
91,1200, // ws
92,279, // " "
93,1279, // {10}
107,MIN_REDUCTION+91, // "["
MIN_REDUCTION+91, // (default reduction)
  }
,
{ // state 1366
0x80000000|1208, // match move
0x80000000|665, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1367
7,671, // ID
21,1333, // <empty bracket pair>
22,61, // `[
66,732, // letter
67,848, // "a"
68,848, // "p"
69,848, // "v"
70,848, // "c"
71,848, // "f"
72,848, // "i"
73,848, // "l"
74,848, // "o"
75,848, // "r"
76,848, // "u"
77,848, // "b"
78,848, // "e"
79,848, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,848, // "h"
81,848, // "n"
82,848, // "t"
83,1273, // letter128
84,1102, // {199..218 231..250}
85,1102, // {193..198 225..230}
107,1202, // "["
  }
,
{ // state 1368
MIN_REDUCTION+1, // (default reduction)
  }
,
{ // state 1369
22,MIN_REDUCTION+182, // `[
91,722, // ws
92,262, // " "
93,1275, // {10}
107,MIN_REDUCTION+182, // "["
MIN_REDUCTION+182, // (default reduction)
  }
,
{ // state 1370
0x80000000|702, // match move
0x80000000|1081, // no-match move
0x80000000|59, // NT-test-match state for `else
  }
,
{ // state 1371
MIN_REDUCTION+49, // (default reduction)
  }
,
{ // state 1372
43,1055, // `<
45,663, // `>
46,133, // `<=
47,607, // `>=
48,185, // `instanceof
94,136, // "#"
97,296, // "@"
110,1337, // "<"
111,562, // ">"
MIN_REDUCTION+34, // (default reduction)
  }
,
{ // state 1373
0x80000000|1206, // match move
0x80000000|683, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1374
MIN_REDUCTION+49, // (default reduction)
  }
,
{ // state 1375
0x80000000|1, // match move
0x80000000|1078, // no-match move
0x80000000|51, // NT-test-match state for <empty bracket pair>
  }
,
{ // state 1376
75,390, // "r"
80,775, // "h"
  }
,
{ // state 1377
2,60, // ws*
  }
,
{ // state 1378
MIN_REDUCTION+178, // (default reduction)
  }
,
{ // state 1379
MIN_REDUCTION+49, // (default reduction)
  }
,
{ // state 1380
MIN_REDUCTION+18, // (default reduction)
  }
,
{ // state 1381
49,868, // `+
51,887, // `-
95,307, // "+"
105,151, // "-"
MIN_REDUCTION+38, // (default reduction)
  }
,
{ // state 1382
66,724, // letter
67,83, // "a"
68,83, // "p"
69,83, // "v"
70,83, // "c"
71,83, // "f"
72,83, // "i"
73,83, // "l"
74,83, // "o"
75,83, // "r"
76,83, // "u"
77,83, // "b"
78,83, // "e"
79,83, // {"A".."Z" "d" "g" "j".."k" "m" "q" "s" "w".."z"}
80,83, // "h"
81,83, // "n"
82,83, // "t"
83,1192, // letter128
84,896, // {199..218 231..250}
85,896, // {193..198 225..230}
86,329, // digit
87,305, // {"1".."9"}
88,305, // "0"
89,1199, // digit128
90,1295, // {176..185}
115,540, // idChar*
116,874, // $$0
121,301, // idChar
122,1272, // "_"
123,16, // idChar128
124,1386, // {223}
  }
,
{ // state 1383
91,580, // ws
92,82, // " "
93,179, // {10}
MIN_REDUCTION+114, // (default reduction)
  }
,
{ // state 1384
82,632, // "t"
  }
,
{ // state 1385
MIN_REDUCTION+24, // (default reduction)
  }
,
{ // state 1386
MIN_REDUCTION+161, // (default reduction)
  }
,
{ // state 1387
82,637, // "t"
  }
,
{ // state 1388
2,285, // ws*
91,1010, // ws
92,1074, // " "
93,1290, // {10}
MIN_REDUCTION+135, // (default reduction)
  }
,
{ // state 1389
2,315, // ws*
22,MIN_REDUCTION+91, // `[
91,1201, // ws
92,278, // " "
93,1280, // {10}
107,MIN_REDUCTION+91, // "["
MIN_REDUCTION+91, // (default reduction)
  }
,
{ // state 1390
MIN_REDUCTION+160, // (default reduction)
  }
,
{ // state 1391
23,564, // `]
108,588, // "]"
  }
,
{ // state 1392
75,389, // "r"
80,780, // "h"
  }
,
};
}
public MJGrammarParseTable(MJGrammar actionObj) {
  actionObject = actionObj;
  parseTable = new int[1393][];
  int doneSoFar = 0;
  doneSoFar += new Initter1().doInit(doneSoFar);
  doneSoFar += new Initter2().doInit(doneSoFar);
  doneSoFar += new Initter3().doInit(doneSoFar);
  doneSoFar += new Initter4().doInit(doneSoFar);
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
// <stmt> ::= `break `;
(24<<16)+2,
// <stmt> ::= ID `++
(24<<16)+2,
// <stmt> ::= ID `--
(24<<16)+2,
// <stmt> ::= `++ ID
(24<<16)+2,
// <stmt> ::= `-- ID
(24<<16)+2,
// <stmt> ::= `if `( <expr> `) <stmt> `else <stmt>
(24<<16)+7,
// <stmt> ::= `if `( <expr> `) <stmt> !`else
(24<<16)+5,
// <stmt> ::= `{ <stmt>* `}
(24<<16)+3,
// <stmt> ::= `{ `}
(24<<16)+2,
// <stmt> ::= <local var decl> `;
(24<<16)+2,
// <assign> ::= <expr> `= <expr>
(25<<16)+3,
// <local var decl> ::= <type> ID `= <expr>
(33<<16)+4,
// <expr> ::= <expr8>
(31<<16)+1,
// <expr8> ::= <expr8> `|| <expr7>
(35<<16)+3,
// <expr8> ::= <expr7>
(35<<16)+1,
// <expr7> ::= <expr7> `&& <expr6>
(37<<16)+3,
// <expr7> ::= <expr6>
(37<<16)+1,
// <expr6> ::= <expr6> `== <expr5>
(39<<16)+3,
// <expr6> ::= <expr6> `!= <expr5>
(39<<16)+3,
// <expr6> ::= <expr5>
(39<<16)+1,
// <expr5> ::= <expr5> `< <expr4>
(41<<16)+3,
// <expr5> ::= <expr5> `> <expr4>
(41<<16)+3,
// <expr5> ::= <expr5> `<= <expr4>
(41<<16)+3,
// <expr5> ::= <expr5> `>= <expr4>
(41<<16)+3,
// <expr5> ::= <expr5> `instanceof <type>
(41<<16)+3,
// <expr5> ::= <expr4>
(41<<16)+1,
// <expr4> ::= <expr4> `+ <expr3>
(44<<16)+3,
// <expr4> ::= <expr4> `- <expr3>
(44<<16)+3,
// <expr4> ::= <expr3>
(44<<16)+1,
// <expr3> ::= <expr3> `* <expr2>
(50<<16)+3,
// <expr3> ::= <expr3> `/ <expr2>
(50<<16)+3,
// <expr3> ::= <expr3> `% <expr2>
(50<<16)+3,
// <expr3> ::= <expr2>
(50<<16)+1,
// <expr2> ::= <cast expr>
(53<<16)+1,
// <cast expr> ::= `( <type> `) <cast expr>
(56<<16)+4,
// <cast expr> ::= `( <type> `) <expr1>
(56<<16)+4,
// <expr2> ::= <unary expr>
(53<<16)+1,
// <unary expr> ::= `- <unary expr>
(58<<16)+2,
// <unary expr> ::= `+ <unary expr>
(58<<16)+2,
// <unary expr> ::= `! <unary expr>
(58<<16)+2,
// <unary expr> ::= <expr1>
(58<<16)+1,
// <expr1> ::= <expr1> `. ID
(57<<16)+3,
// <expr1> ::= ID
(57<<16)+1,
// <expr1> ::= <expr1> !<empty bracket pair> `[ <expr> `]
(57<<16)+4,
// <expr1> ::= INTLIT
(57<<16)+1,
// <expr1> ::= `true
(57<<16)+1,
// <expr1> ::= `false
(57<<16)+1,
// <expr1> ::= `null
(57<<16)+1,
// <expr1> ::= `this
(57<<16)+1,
// letter ::= {"A".."Z" "a".."z"}
(66<<16)+1,
// letter128 ::= {193..218 225..250}
(83<<16)+1,
// digit ::= {"0".."9"}
(86<<16)+1,
// digit128 ::= {176..185}
(89<<16)+1,
// ws ::= " "
(91<<16)+1,
// ws ::= {10}
(91<<16)+1,
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
// `if ::= "#" "+" ws*
(30<<16)+3,
// `if ::= "#" "+"
(30<<16)+2,
// `else ::= "#" "e" "l" ws*
(32<<16)+4,
// `else ::= "#" "e" "l"
(32<<16)+3,
// `break ::= "#" "b" "r" ws*
(27<<16)+4,
// `break ::= "#" "b" "r"
(27<<16)+3,
// `this ::= "#" "t" "h" ws*
(65<<16)+4,
// `this ::= "#" "t" "h"
(65<<16)+3,
// `false ::= "#" "f" "a" ws*
(63<<16)+4,
// `false ::= "#" "f" "a"
(63<<16)+3,
// `true ::= "#" "t" "r" ws*
(62<<16)+4,
// `true ::= "#" "t" "r"
(62<<16)+3,
// `null ::= "#" "n" "u" ws*
(64<<16)+4,
// `null ::= "#" "n" "u"
(64<<16)+3,
// `instanceof ::= "#" "i" "n" ws*
(48<<16)+4,
// `instanceof ::= "#" "i" "n"
(48<<16)+3,
// `public ::= "#" "p" "u" ws*
(13<<16)+4,
// `public ::= "#" "p" "u"
(13<<16)+3,
// `! ::= "!" ws*
(59<<16)+2,
// `! ::= "!"
(59<<16)+1,
// `!= ::= "@" "!" ws*
(42<<16)+3,
// `!= ::= "@" "!"
(42<<16)+2,
// `% ::= "%" ws*
(55<<16)+2,
// `% ::= "%"
(55<<16)+1,
// `&& ::= "@" "&" ws*
(38<<16)+3,
// `&& ::= "@" "&"
(38<<16)+2,
// `* ::= "*" ws*
(52<<16)+2,
// `* ::= "*"
(52<<16)+1,
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
(51<<16)+2,
// `- ::= "-"
(51<<16)+1,
// `+ ::= "+" ws*
(49<<16)+2,
// `+ ::= "+"
(49<<16)+1,
// `= ::= "=" ws*
(34<<16)+2,
// `= ::= "="
(34<<16)+1,
// `== ::= "@" "=" ws*
(40<<16)+3,
// `== ::= "@" "="
(40<<16)+2,
// `[ ::= "[" ws*
(22<<16)+2,
// `[ ::= "["
(22<<16)+1,
// `] ::= "]" ws*
(23<<16)+2,
// `] ::= "]"
(23<<16)+1,
// `|| ::= "@" "|" ws*
(36<<16)+3,
// `|| ::= "@" "|"
(36<<16)+2,
// `< ::= "<" ws*
(43<<16)+2,
// `< ::= "<"
(43<<16)+1,
// `<= ::= "@" "<" ws*
(46<<16)+3,
// `<= ::= "@" "<"
(46<<16)+2,
// `> ::= ">" !"=" ws*
(45<<16)+2,
// `> ::= ">" !"="
(45<<16)+1,
// `>= ::= "@" ">" ws*
(47<<16)+3,
// `>= ::= "@" ">"
(47<<16)+2,
// `. ::= "." ws*
(60<<16)+2,
// `. ::= "."
(60<<16)+1,
// `; ::= ";" ws*
(26<<16)+2,
// `; ::= ";"
(26<<16)+1,
// `++ ::= "@" "+" ws*
(28<<16)+3,
// `++ ::= "@" "+"
(28<<16)+2,
// `-- ::= "@" "-" ws*
(29<<16)+3,
// `-- ::= "@" "-"
(29<<16)+2,
// `/ ::= "/" ws*
(54<<16)+2,
// `/ ::= "/"
(54<<16)+1,
// ID ::= letter128 ws*
(7<<16)+2,
// ID ::= letter128
(7<<16)+1,
// ID ::= letter idChar* $$0
(7<<16)+3,
// ID ::= letter $$0
(7<<16)+2,
// INTLIT ::= {"1".."9"} digit* $$1
(61<<16)+3,
// INTLIT ::= {"1".."9"} $$1
(61<<16)+2,
// INTLIT ::= digit128 ws*
(61<<16)+2,
// INTLIT ::= digit128
(61<<16)+1,
// INTLIT ::= "0" hexDigit* $$2
(61<<16)+3,
// INTLIT ::= "0" $$2
(61<<16)+2,
// idChar ::= letter
(121<<16)+1,
// idChar ::= digit
(121<<16)+1,
// idChar ::= "_"
(121<<16)+1,
// idChar128 ::= letter128
(123<<16)+1,
// idChar128 ::= digit128
(123<<16)+1,
// idChar128 ::= {223}
(123<<16)+1,
// hexDigit ::= {"0".."9" "A".."Z" "a".."z"}
(125<<16)+1,
// hexDigit128 ::= {176..185 193..198 225..230}
(126<<16)+1,
// digit* ::= digit* digit
(117<<16)+2,
// digit* ::= digit
(117<<16)+1,
// <decl in class>* ::= <decl in class>* <decl in class>
(9<<16)+2,
// <decl in class>* ::= <decl in class>
(9<<16)+1,
// hexDigit* ::= hexDigit* hexDigit
(119<<16)+2,
// hexDigit* ::= hexDigit
(119<<16)+1,
// <stmt>* ::= <stmt>* <stmt>
(17<<16)+2,
// <stmt>* ::= <stmt>
(17<<16)+1,
// idChar* ::= idChar* idChar
(115<<16)+2,
// idChar* ::= idChar
(115<<16)+1,
// <class decl>+ ::= <class decl>
(4<<16)+1,
// <class decl>+ ::= <class decl>+ <class decl>
(4<<16)+2,
// ws* ::= ws* ws
(2<<16)+2,
// ws* ::= ws
(2<<16)+1,
// $$0 ::= idChar128 ws*
(116<<16)+2,
// $$0 ::= idChar128
(116<<16)+1,
// $$1 ::= digit128 ws*
(118<<16)+2,
// $$1 ::= digit128
(118<<16)+1,
// $$2 ::= hexDigit128 ws*
(120<<16)+2,
// $$2 ::= hexDigit128
(120<<16)+1,
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
93, // 10
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
92, // " "
96, // "!"
-1, // '"'
94, // "#"
-1, // "$"
98, // "%"
99, // "&"
-1, // "'"
101, // "("
102, // ")"
100, // "*"
95, // "+"
-1, // ","
105, // "-"
112, // "."
114, // "/"
88, // "0"
87, // "1"
87, // "2"
87, // "3"
87, // "4"
87, // "5"
87, // "6"
87, // "7"
87, // "8"
87, // "9"
-1, // ":"
113, // ";"
110, // "<"
106, // "="
111, // ">"
-1, // "?"
97, // "@"
79, // "A"
79, // "B"
79, // "C"
79, // "D"
79, // "E"
79, // "F"
79, // "G"
79, // "H"
79, // "I"
79, // "J"
79, // "K"
79, // "L"
79, // "M"
79, // "N"
79, // "O"
79, // "P"
79, // "Q"
79, // "R"
79, // "S"
79, // "T"
79, // "U"
79, // "V"
79, // "W"
79, // "X"
79, // "Y"
79, // "Z"
107, // "["
-1, // "\"
108, // "]"
-1, // "^"
122, // "_"
-1, // "`"
67, // "a"
77, // "b"
70, // "c"
79, // "d"
78, // "e"
71, // "f"
79, // "g"
80, // "h"
72, // "i"
79, // "j"
79, // "k"
73, // "l"
79, // "m"
81, // "n"
74, // "o"
68, // "p"
79, // "q"
75, // "r"
79, // "s"
82, // "t"
76, // "u"
69, // "v"
79, // "w"
79, // "x"
79, // "y"
79, // "z"
103, // "{"
109, // "|"
104, // "}"
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
90, // 176
90, // 177
90, // 178
90, // 179
90, // 180
90, // 181
90, // 182
90, // 183
90, // 184
90, // 185
-1, // 186
-1, // 187
-1, // 188
-1, // 189
-1, // 190
-1, // 191
-1, // 192
85, // 193
85, // 194
85, // 195
85, // 196
85, // 197
85, // 198
84, // 199
84, // 200
84, // 201
84, // 202
84, // 203
84, // 204
84, // 205
84, // 206
84, // 207
84, // 208
84, // 209
84, // 210
84, // 211
84, // 212
84, // 213
84, // 214
84, // 215
84, // 216
84, // 217
84, // 218
-1, // 219
-1, // 220
-1, // 221
-1, // 222
124, // 223
-1, // 224
85, // 225
85, // 226
85, // 227
85, // 228
85, // 229
85, // 230
84, // 231
84, // 232
84, // 233
84, // 234
84, // 235
84, // 236
84, // 237
84, // 238
84, // 239
84, // 240
84, // 241
84, // 242
84, // 243
84, // 244
84, // 245
84, // 246
84, // 247
84, // 248
84, // 249
84, // 250
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
"", // 129
"", // 130
"", // 131
"", // 132
"", // 133
"", // 134
"", // 135
"", // 136
"", // 137
"", // 138
"", // 139
"", // 140
"", // 141
"", // 142
"", // 143
"", // 144
"", // 145
"", // 146
"", // 147
"", // 148
"", // 149
"", // 150
"", // 151
"", // 152
"", // 153
"", // 154
"", // 155
"", // 156
"", // 157
"", // 158
"", // 159
"", // 160
"", // 161
"", // 162
"", // 163
"digit* ::= digit* digit", // 164
"digit* ::= digit* digit", // 165
"<decl in class>* ::= <decl in class>* <decl in class>", // 166
"<decl in class>* ::= <decl in class>* <decl in class>", // 167
"hexDigit* ::= hexDigit* hexDigit", // 168
"hexDigit* ::= hexDigit* hexDigit", // 169
"<stmt>* ::= <stmt>* <stmt>", // 170
"<stmt>* ::= <stmt>* <stmt>", // 171
"idChar* ::= idChar* idChar", // 172
"idChar* ::= idChar* idChar", // 173
"<class decl>+ ::= <class decl>", // 174
"<class decl>+ ::= <class decl>+ <class decl>", // 175
"ws* ::= ws* ws", // 176
"ws* ::= ws* ws", // 177
"", // 178
"", // 179
"", // 180
"", // 181
"", // 182
"", // 183
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
    { // 15: <stmt> ::= [#] `break `; @breakStmt(int)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((8<<5)|0x5)/*methodCall:8*/,
    },
    { // 16: <stmt> ::= [#] ID `++ @postIncrement(int,String)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((9<<5)|0x5)/*methodCall:9*/,
    },
    { // 17: <stmt> ::= [#] ID `-- @postDecrement(int,String)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((10<<5)|0x5)/*methodCall:10*/,
    },
    { // 18: <stmt> ::= [#] `++ ID @preIncrement(int,String)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((11<<5)|0x5)/*methodCall:11*/,
    },
    { // 19: <stmt> ::= [#] `-- ID @preDecrement(int,String)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((12<<5)|0x5)/*methodCall:12*/,
    },
    { // 20: <stmt> ::= [#] `if `( <expr> `) <stmt> `else <stmt> @ifElseStmt(int,Exp,Stmt,Stmt)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((13<<5)|0x5)/*methodCall:13*/,
    },
    { // 21: <stmt> ::= [#] `if `( <expr> `) <stmt> !`else @ifStmt(int,Exp,Stmt)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((14<<5)|0x5)/*methodCall:14*/,
    },
    { // 22: <stmt> ::= [#] `{ <stmt>* `} @newBlock(int,List<Stmt>)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((15<<5)|0x5)/*methodCall:15*/,
    },
    { // 23: <stmt> ::= [#] `{ [<stmt>*] `} @newBlock(int,List<Stmt>)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x6)/*nullProductionAction:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((15<<5)|0x5)/*methodCall:15*/,
    },
    { // 24: <stmt> ::= <local var decl> `; @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 25: <assign> ::= <expr> [#] `= <expr> @assign(Exp,int,Exp)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((16<<5)|0x5)/*methodCall:16*/,
    },
    { // 26: <local var decl> ::= <type> [#] ID `= <expr> @localVarDecl(Type,int,String,Exp)=>Stmt
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((17<<5)|0x5)/*methodCall:17*/,
    },
    { // 27: <expr> ::= <expr8> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 28: <expr8> ::= <expr8> [#] `|| <expr7> @newOr(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((18<<5)|0x5)/*methodCall:18*/,
    },
    { // 29: <expr8> ::= <expr7> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 30: <expr7> ::= <expr7> [#] `&& <expr6> @newAnd(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((19<<5)|0x5)/*methodCall:19*/,
    },
    { // 31: <expr7> ::= <expr6> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 32: <expr6> ::= <expr6> [#] `== <expr5> @newEqualEqual(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((20<<5)|0x5)/*methodCall:20*/,
    },
    { // 33: <expr6> ::= <expr6> [#] `!= <expr5> @newNotEquals(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((21<<5)|0x5)/*methodCall:21*/,
    },
    { // 34: <expr6> ::= <expr5> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 35: <expr5> ::= <expr5> [#] `< <expr4> @newLessThan(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((22<<5)|0x5)/*methodCall:22*/,
    },
    { // 36: <expr5> ::= <expr5> [#] `> <expr4> @newGreaterThan(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((23<<5)|0x5)/*methodCall:23*/,
    },
    { // 37: <expr5> ::= <expr5> [#] `<= <expr4> @newLessThanEqual(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((24<<5)|0x5)/*methodCall:24*/,
    },
    { // 38: <expr5> ::= <expr5> [#] `>= <expr4> @newGreaterThanEqual(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((25<<5)|0x5)/*methodCall:25*/,
    },
    { // 39: <expr5> ::= <expr5> [#] `instanceof <type> @newInstanceof(Exp,int,Type)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((26<<5)|0x5)/*methodCall:26*/,
    },
    { // 40: <expr5> ::= <expr4> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 41: <expr4> ::= <expr4> [#] `+ <expr3> @newPlus(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((27<<5)|0x5)/*methodCall:27*/,
    },
    { // 42: <expr4> ::= <expr4> [#] `- <expr3> @newMinus(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((28<<5)|0x5)/*methodCall:28*/,
    },
    { // 43: <expr4> ::= <expr3> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 44: <expr3> ::= <expr3> [#] `* <expr2> @newTimes(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((29<<5)|0x5)/*methodCall:29*/,
    },
    { // 45: <expr3> ::= <expr3> [#] `/ <expr2> @newDivide(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((30<<5)|0x5)/*methodCall:30*/,
    },
    { // 46: <expr3> ::= <expr3> [#] `% <expr2> @newMod(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((31<<5)|0x5)/*methodCall:31*/,
    },
    { // 47: <expr3> ::= <expr2> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 48: <expr2> ::= <cast expr> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 49: <cast expr> ::= [#] `( <type> `) <cast expr> @newCast(int,Type,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((32<<5)|0x5)/*methodCall:32*/,
    },
    { // 50: <cast expr> ::= [#] `( <type> `) <expr1> @newCast(int,Type,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((32<<5)|0x5)/*methodCall:32*/,
    },
    { // 51: <expr2> ::= <unary expr> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 52: <unary expr> ::= [#] `- <unary expr> @newUnaryMinus(int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((33<<5)|0x5)/*methodCall:33*/,
    },
    { // 53: <unary expr> ::= [#] `+ <unary expr> @newUnaryPlus(int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((34<<5)|0x5)/*methodCall:34*/,
    },
    { // 54: <unary expr> ::= [#] `! <unary expr> @newNot(int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((35<<5)|0x5)/*methodCall:35*/,
    },
    { // 55: <unary expr> ::= <expr1> @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 56: <expr1> ::= [#] <expr1> `. ID @newFieldAccess(int,Exp,String)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((36<<5)|0x5)/*methodCall:36*/,
    },
    { // 57: <expr1> ::= [#] ID @newIDExp(int,String)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((37<<5)|0x5)/*methodCall:37*/,
    },
    { // 58: <expr1> ::= <expr1> !<empty bracket pair> [#] `[ <expr> `] @newArrayLookup(Exp,int,Exp)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((38<<5)|0x5)/*methodCall:38*/,
    },
    { // 59: <expr1> ::= [#] INTLIT @newIntLit(int,int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((39<<5)|0x5)/*methodCall:39*/,
    },
    { // 60: <expr1> ::= [#] `true @newTrue(int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((40<<5)|0x5)/*methodCall:40*/,
    },
    { // 61: <expr1> ::= [#] `false @newFalse(int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((41<<5)|0x5)/*methodCall:41*/,
    },
    { // 62: <expr1> ::= [#] `null @newNull(int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((42<<5)|0x5)/*methodCall:42*/,
    },
    { // 63: <expr1> ::= [#] `this @newThis(int)=>Exp
      ((1<<5)|0xe)/*popPos:1*/,
      ((6<<5)|0x6)/*nullProductionAction:6*/,
      ((43<<5)|0x5)/*methodCall:43*/,
    },
    { // 64: letter ::= {"A".."Z" "a".."z"} @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 65: letter128 ::= {193..218 225..250} @sub128(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((44<<5)|0x5)/*methodCall:44*/,
    },
    { // 66: digit ::= {"0".."9"} @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 67: digit128 ::= {176..185} @sub128(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((44<<5)|0x5)/*methodCall:44*/,
    },
    { // 68: ws ::= " " @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 69: ws ::= {10} [registerNewline] @void
      ((7<<5)|0x6)/*nullProductionAction:7*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 70: `boolean ::= "#" "b" "o" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 71: `boolean ::= "#" "b" "o" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 72: `class ::= "#" "c" "l" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 73: `class ::= "#" "c" "l" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 74: `void ::= "#" "v" "o" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 75: `void ::= "#" "v" "o" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 76: `int ::= "#" "i" "t" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 77: `int ::= "#" "i" "t" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 78: `if ::= "#" "+" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 79: `if ::= "#" "+" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 80: `else ::= "#" "e" "l" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 81: `else ::= "#" "e" "l" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 82: `break ::= "#" "b" "r" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 83: `break ::= "#" "b" "r" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 84: `this ::= "#" "t" "h" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 85: `this ::= "#" "t" "h" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 86: `false ::= "#" "f" "a" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 87: `false ::= "#" "f" "a" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 88: `true ::= "#" "t" "r" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 89: `true ::= "#" "t" "r" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 90: `null ::= "#" "n" "u" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 91: `null ::= "#" "n" "u" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 92: `instanceof ::= "#" "i" "n" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 93: `instanceof ::= "#" "i" "n" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 94: `public ::= "#" "p" "u" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 95: `public ::= "#" "p" "u" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x3)/*popOffPushBack:3*/,
    },
    { // 96: `! ::= "!" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 97: `! ::= "!" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 98: `!= ::= "@" "!" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 99: `!= ::= "@" "!" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 100: `% ::= "%" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 101: `% ::= "%" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 102: `&& ::= "@" "&" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 103: `&& ::= "@" "&" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 104: `* ::= "*" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 105: `* ::= "*" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 106: `( ::= "(" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 107: `( ::= "(" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 108: `) ::= ")" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 109: `) ::= ")" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 110: `{ ::= "{" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 111: `{ ::= "{" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 112: `} ::= "}" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 113: `} ::= "}" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 114: `- ::= "-" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 115: `- ::= "-" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 116: `+ ::= "+" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 117: `+ ::= "+" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 118: `= ::= "=" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 119: `= ::= "=" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 120: `== ::= "@" "=" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 121: `== ::= "@" "=" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 122: `[ ::= "[" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 123: `[ ::= "[" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 124: `] ::= "]" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 125: `] ::= "]" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 126: `|| ::= "@" "|" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 127: `|| ::= "@" "|" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 128: `< ::= "<" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 129: `< ::= "<" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 130: `<= ::= "@" "<" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 131: `<= ::= "@" "<" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 132: `> ::= ">" !"=" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 133: `> ::= ">" !"=" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 134: `>= ::= "@" ">" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 135: `>= ::= "@" ">" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 136: `. ::= "." ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 137: `. ::= "." [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 138: `; ::= ";" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 139: `; ::= ";" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 140: `++ ::= "@" "+" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 141: `++ ::= "@" "+" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 142: `-- ::= "@" "-" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 143: `-- ::= "@" "-" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x3)/*popOffPushBack:2*/,
    },
    { // 144: `/ ::= "/" ws* @void
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 145: `/ ::= "/" [ws*] @void
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x3)/*popOffPushBack:1*/,
    },
    { // 146: ID ::= letter128 ws* @text
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x4)/*stringConcat:1*/,
    },
    { // 147: ID ::= letter128 [ws*] @text
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x4)/*stringConcat:1*/,
    },
    { // 148: ID ::= letter idChar* $$0 @text
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x4)/*stringConcat:3*/,
    },
    { // 149: ID ::= letter [idChar*] $$0 @text
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((4<<5)|0x6)/*nullProductionAction:4*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((3<<5)|0x4)/*stringConcat:3*/,
    },
    { // 150: INTLIT ::= {"1".."9"} digit* $$1 @convertToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((45<<5)|0x5)/*methodCall:45*/,
    },
    { // 151: INTLIT ::= {"1".."9"} [digit*] $$1 @convertToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((45<<5)|0x5)/*methodCall:45*/,
    },
    { // 152: INTLIT ::= digit128 ws* @convertToInt(char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((46<<5)|0x5)/*methodCall:46*/,
    },
    { // 153: INTLIT ::= digit128 [ws*] @convertToInt(char)=>int
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((46<<5)|0x5)/*methodCall:46*/,
    },
    { // 154: INTLIT ::= "0" hexDigit* $$2 @convert16ToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((47<<5)|0x5)/*methodCall:47*/,
    },
    { // 155: INTLIT ::= "0" [hexDigit*] $$2 @convert16ToInt(char,List<Character>,char)=>int
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((0<<5)|0x6)/*nullProductionAction:0*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((47<<5)|0x5)/*methodCall:47*/,
    },
    { // 156: idChar ::= letter @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 157: idChar ::= digit @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 158: idChar ::= "_" @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 159: idChar128 ::= letter128 @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 160: idChar128 ::= digit128 @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 161: idChar128 ::= {223} @underscore(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((48<<5)|0x5)/*methodCall:48*/,
    },
    { // 162: hexDigit ::= {"0".."9" "A".."Z" "a".."z"} @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 163: hexDigit128 ::= {176..185 193..198 225..230} @sub128(char)=>char
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((44<<5)|0x5)/*methodCall:44*/,
    },
    { // 164: digit* ::= digit* digit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 165: digit* ::= [digit*] digit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((5<<5)|0x6)/*nullProductionAction:5*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 166: <decl in class>* ::= <decl in class>* <decl in class> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 167: <decl in class>* ::= [<decl in class>*] <decl in class> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((2<<5)|0x6)/*nullProductionAction:2*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 168: hexDigit* ::= hexDigit* hexDigit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 169: hexDigit* ::= [hexDigit*] hexDigit @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((0<<5)|0x6)/*nullProductionAction:0*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 170: <stmt>* ::= <stmt>* <stmt> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 171: <stmt>* ::= [<stmt>*] <stmt> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0x6)/*nullProductionAction:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 172: idChar* ::= idChar* idChar @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 173: idChar* ::= [idChar*] idChar @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((4<<5)|0x6)/*nullProductionAction:4*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 174: <class decl>+ ::= <class decl> @singleList
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xa)/*singleList:1*/,
    },
    { // 175: <class decl>+ ::= <class decl>+ <class decl> @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
      ((1<<5)|0xb)/*append:1*/,
    },
    { // 176: ws* ::= ws* ws @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
    },
    { // 177: ws* ::= [ws*] ws @append
      ((1<<5)|0xe)/*popPos:1*/,
      ((3<<5)|0x6)/*nullProductionAction:3*/,
    },
    { // 178: $$0 ::= idChar128 ws* @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 179: $$0 ::= idChar128 [ws*] @pass
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 180: $$1 ::= digit128 ws* @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 181: $$1 ::= digit128 [ws*] @pass
      ((3<<5)|0x6)/*nullProductionAction:3*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 182: $$2 ::= hexDigit128 ws* @pass
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0xe)/*popPos:1*/,
      ((1<<5)|0x0)/*popToPushBack:1*/,
    },
    { // 183: $$2 ::= hexDigit128 [ws*] @pass
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
      ((49<<5)|0x5)/*methodCall:49*/,
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
      Stmt result = actionObject.breakStmt(parm0);
      si.pushPb(result);
    }
    break;
    case 9: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Stmt result = actionObject.postIncrement(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 10: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Stmt result = actionObject.postDecrement(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 11: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Stmt result = actionObject.preIncrement(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 12: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Stmt result = actionObject.preDecrement(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 13: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      Stmt parm2 = (Stmt)si.popPb();
      Stmt parm3 = (Stmt)si.popPb();
      Stmt result = actionObject.ifElseStmt(parm0,parm1,parm2,parm3);
      si.pushPb(result);
    }
    break;
    case 14: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      Stmt parm2 = (Stmt)si.popPb();
      Stmt result = actionObject.ifStmt(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 15: {
      int parm0 = (Integer)si.popPb();
      List<Stmt> parm1 = (List<Stmt>)si.popPb();
      Stmt result = actionObject.newBlock(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 16: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Stmt result = actionObject.assign(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 17: {
      Type parm0 = (Type)si.popPb();
      int parm1 = (Integer)si.popPb();
      String parm2 = (String)si.popPb();
      Exp parm3 = (Exp)si.popPb();
      Stmt result = actionObject.localVarDecl(parm0,parm1,parm2,parm3);
      si.pushPb(result);
    }
    break;
    case 18: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newOr(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 19: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newAnd(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 20: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newEqualEqual(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 21: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newNotEquals(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 22: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newLessThan(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 23: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newGreaterThan(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 24: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newLessThanEqual(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 25: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newGreaterThanEqual(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 26: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Type parm2 = (Type)si.popPb();
      Exp result = actionObject.newInstanceof(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 27: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newPlus(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 28: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newMinus(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 29: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newTimes(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 30: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newDivide(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 31: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newMod(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 32: {
      int parm0 = (Integer)si.popPb();
      Type parm1 = (Type)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newCast(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 33: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      Exp result = actionObject.newUnaryMinus(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 34: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      Exp result = actionObject.newUnaryPlus(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 35: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      Exp result = actionObject.newNot(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 36: {
      int parm0 = (Integer)si.popPb();
      Exp parm1 = (Exp)si.popPb();
      String parm2 = (String)si.popPb();
      Exp result = actionObject.newFieldAccess(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 37: {
      int parm0 = (Integer)si.popPb();
      String parm1 = (String)si.popPb();
      Exp result = actionObject.newIDExp(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 38: {
      Exp parm0 = (Exp)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp parm2 = (Exp)si.popPb();
      Exp result = actionObject.newArrayLookup(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 39: {
      int parm0 = (Integer)si.popPb();
      int parm1 = (Integer)si.popPb();
      Exp result = actionObject.newIntLit(parm0,parm1);
      si.pushPb(result);
    }
    break;
    case 40: {
      int parm0 = (Integer)si.popPb();
      Exp result = actionObject.newTrue(parm0);
      si.pushPb(result);
    }
    break;
    case 41: {
      int parm0 = (Integer)si.popPb();
      Exp result = actionObject.newFalse(parm0);
      si.pushPb(result);
    }
    break;
    case 42: {
      int parm0 = (Integer)si.popPb();
      Exp result = actionObject.newNull(parm0);
      si.pushPb(result);
    }
    break;
    case 43: {
      int parm0 = (Integer)si.popPb();
      Exp result = actionObject.newThis(parm0);
      si.pushPb(result);
    }
    break;
    case 44: {
      char parm0 = (Character)si.popPb();
      char result = actionObject.sub128(parm0);
      si.pushPb(result);
    }
    break;
    case 45: {
      char parm0 = (Character)si.popPb();
      List<Character> parm1 = (List<Character>)si.popPb();
      char parm2 = (Character)si.popPb();
      int result = actionObject.convertToInt(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 46: {
      char parm0 = (Character)si.popPb();
      int result = actionObject.convertToInt(parm0);
      si.pushPb(result);
    }
    break;
    case 47: {
      char parm0 = (Character)si.popPb();
      List<Character> parm1 = (List<Character>)si.popPb();
      char parm2 = (Character)si.popPb();
      int result = actionObject.convert16ToInt(parm0,parm1,parm2);
      si.pushPb(result);
    }
    break;
    case 48: {
      char parm0 = (Character)si.popPb();
      char result = actionObject.underscore(parm0);
      si.pushPb(result);
    }
    break;
    case 49: {
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
"Stmt breakStmt(int)",
"Stmt postIncrement(int,String)",
"Stmt postDecrement(int,String)",
"Stmt preIncrement(int,String)",
"Stmt preDecrement(int,String)",
"Stmt ifElseStmt(int,Exp,Stmt,Stmt)",
"Stmt ifStmt(int,Exp,Stmt)",
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
"Exp newNot(int,Exp)",
"Exp newFieldAccess(int,Exp,String)",
"Exp newIDExp(int,String)",
"Exp newArrayLookup(Exp,int,Exp)",
"Exp newIntLit(int,int)",
"Exp newTrue(int)",
"Exp newFalse(int)",
"Exp newNull(int)",
"Exp newThis(int)",
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
1,1,
2,1,
2,1,
2,1,
2,1,
4,1,
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
3,1,
2,1,
1,1,
1,1,
1,1,
1,1,
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
    0,
    0,
    0,
    0,
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
    0,
    0,
    1,
    0,
    0,
    0,
    0,
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
