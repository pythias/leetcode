<?php
/**
 * 424. Longest Repeating Character Replacement
 * @link https://leetcode.com/problems/longest-repeating-character-replacement/
 */
class S0424 {

    /**
     * @param String $s
     * @param Integer $k
     * @return Integer
     */
    public function characterReplacement($s, $k) {
        return $this->s2($s, $k);
    }

    public function s2($s, $k) {
        $length = strlen($s);
        $counts = array_fill(ord('A'), 26, 0);
        $max = 0;
        $left = 0;
        $right = 0;
        while ($right < $length) {
            $char = ord($s[$right]);
            $counts[$char]++;
            $max = max($max, $counts[$char]);
            if (($right - $left + 1) > ($max + $k)) {
                $counts[ord($s[$left])]--;
                $left++;
            }

            $right++;
        }

        return $right - $left;
    }

    public function s1($s, $k) {
        $length = strlen($s);
        if ($length == 1) {
            return 1;
        }

        $index = 0;
        $size = 0;
        $lastChar = $s[1];
        $lastIndex = -1;
        $maxSize = 0;
        $remain = $k;
        while ($index < $length) { 
            $char = $s[$index];
            if ($char == $lastChar) {
                $size++;
            } else {
                if ($lastIndex == -1) {
                    $lastIndex = $index;
                }

                if (--$remain < 0) {
                    $index = $lastIndex;
                    $size = 0;
                    $lastChar = $s[$index];
                    $lastIndex = -1;
                    $remain = $k;
                    continue;
                }

                $size++;
            }

            $maxSize = max($maxSize, $size);
            $index++;
        }

        return $maxSize;
    }
}

$solution = new S0424();
var_dump($solution->characterReplacement("AB", 0));
var_dump($solution->characterReplacement("AB", 1));
var_dump($solution->characterReplacement("ABBB", 0));
var_dump($solution->characterReplacement("ABBB", 1));
var_dump($solution->characterReplacement("ABCD", 1));
var_dump($solution->characterReplacement("BBBA", 1));
var_dump($solution->characterReplacement("ABAB", 2));
var_dump($solution->characterReplacement("AABABBA", 1));
var_dump($solution->characterReplacement("ABCABCBA", 1));

$long = "CCDAEEEDDEBCCDBACFCEDFAECCCCFDEADFECCDEBBEAFEBEEAFDEACBCECEDFBBDECCAAFCDDCABDBAEFABCBAEDCBFAAECEECAEABCBCCABAABECAFEAACEEBCFFFDDCDBCDCACCFFBDBEDBDEDFFECDBDBDABBBDAEACEDFBBAFBABFAEBADCEFDEAFCFDDFFCAFAEEAAEEECBFADCEFADAEEADCBACCDDEFCCCACEBCCEEDBBFFBCEDEFEACBDBBABDCBADDFEADCBEBBCFBCBAECECCCDDADCDBEAFCEADEBBFFACEAAFFDDCEFEEACDFDACFCEAFDCABBBBEBEBDDABEDCAEFCBFEFFABBCFAFCCBDECDBCABFABFABEECEDFFDFFDEBDBBBEEAEFFEDBADAABEEACFCCBEDADFCBDBDDBDCABDFCDECEFBFDFCDCFEBCCDDFABCBBCCCBCABEECBCBCBEADECAFFFCFAEFFFCDADBADFDFFDCBABFADFAAEFBADCCAFEEBFCFEBCFCEDACCADAAEEEBDCADABFBADBAECACBEFAECFFBCFBDEAECEBCFFDCEEEEEAFEBFFAEBBBDBBFFDBFADEECFDEBDBBCEEDBBADDBBDEDDAFEBCEDCAEBEEEDCFEDDACCDDCAEFDECBDCBBEFCFCECAABCFBBACACCEACDCBDBFECBDFFEBBFBABDECAECAFEEDAABEAFBECAACCACEEAADCEFEEBFFCCBDBCCBADDAAAADBFAECFBFACFDECFACDCCBBCADAEBEDDEEDCBDAFDDAAAFECDADBDAACCBDFAEEACFBBDEDDCCEAAEFEBFCAAEDDCFBDEFECBEFACCCDEDAAABEDAECDEEFCDACCBCDFBCADBCFAACCBBDFFBFBCACEABACAFEDCECCBDFAEDCBDCBAAFEDBCCBBFAFAEABFBEEBDCDFECDDDBDDCCBEFCCEDCECFCBEFFFBFBFBFDDCBEDADECCFFAFAEBEAABECFECABDABFBCEDFCCCCADEBCFBECCDFAAFEFEADACDEFFCBACAACFFECAAFDEDECCDFEDADBDAECDFFECAFFFEDEBEDBBBBBABDAEFFFDDDDCCEEEADEBFEAEFDACBFDBFDADEEACECFADACEEDBCECBCEFCBFBDEADAFCDACCFAEFEFAFDFECAABACFFFDCCBBCCDFECEDECDFDBBFACCDFBADFABBFADDFFCAAABEBDFAAEDAACFCCAEECCAFCEEBEEBCCFFEFFDEFBEEFBBFECFADAFFEBAAFBCFBAFBACDFDAEDBEBEEBBFDEDCEFCBBBABCDAEBEFAEBEAFDECABBADBFCEFFFDBAFDBBEBBCAACBFDDCEFEEEDDADBCFCEAACDBFBFDEACDCDFABDACBCAEEDECCDBDBCBACEBBBBADCBFCDDBDFECEECFDFFBDCBAAEBFCFCDFDBBBFCDECBADAFCBFECABACBFDBAFDCDBBBECCDFDFBECEDBCCAEFDAFACEBFDBDFAFCFFACABCAAECCBBEEBDAFAEFFFEBDECBEAECEAECACDBCFEAADBFEADCCEFAFCAADAEEDFBAFACBAFCEACAADDECFBFDBFCCFAABDABFBEEDFDBAFFECBDDCDCBDEBEFDCCBDBFECBFEAFDCDECAFEAAEAABDFDBBFECAECFEBADCFEEDCBDBFDBBECECFBDDBEFAACEABEFCAAFBDACDDFAEEFDAACBEAEAFDAFEECEFECFBABABBCCBFECBBCAFDCEDCBCAEBFBBCCCBBAEFEFBEEDEFCABEFEECCFBAADEFCEFDDDEDDDBBDABEEFECAEEBCCDDFBAEDCBCCEFFBECFBDECAFEEDBECEBACEBFCEFBECEDFABFAADEBACECDEEBDDFAAEFCCFBFCCAEAAEFAEDEEFBADFCDCFAFEDBDADCFFBDBBEDFEDEFDFCAAAFBADDBDCCCCACDDBBFBECCACDAACCBBDFEEBAACAEDEBBDCDEBDADCAADEFFDDAEADDDFBDBAACFDCEEAAAFDEBBFFEBACADCACDEECCCABFDDCAADEAFABCCCEEFEDDDCBEEFFEDFBBAECDEAAADAECEAACBCBBFCFBEEAFFFDEFDDCBDDDAFAFDEBCEEEACACACCBBBCBADDCECBDEDAAADEFDDDEAEBBBEAEFEEBEAABCFCBCAFDCFDDCFDFAABEFCAFEFADBCDDEADEFAFDAFDECBCECEADFCDAECBDBFEAEAACEBFFFAFEEDABBEBCCBAFACEAFFFABCAEAFEDFCBFEAAEDCCBDBFEFFFCDEAEBEBCDCDEEFDBEEAFBBAEEEAABBEDBFACFCACFABAEBAFADBBEBCEBCFECBFDABBAAEDCDECEAADEDBBFAEECCADFCBAFAAFEDAEFDACBDEAABFFAACEFDFCFFCEFACFBDDABCACACDACACDEBACDCDCADEADFBFACEAABCFDCDDAAEFCFEAFCFFAFDCFDEDAEFCEDAFDFFFBECCFEAADEFAACFDEFBEEBCDADDFCDBADBADFFCCCFBBBDDDEEADDADEFDDECFFACCDFCCBBFACFDFBBEFBCEDACACBAECDECBCBCCFEBEEAEECDCDBAADEABFFCFECBBEFACDBFEBAAFBBDFDEEFCCCFEBBBFECCEBDBADBFCDFCDBADCEACCBDCBAAFEEDDFEAEDFEEEEBCAFCDDBCBDDDCABCBFDCBEFCBCEBFDFBCCDBEAABEAFCACDEBEDCAADEDDFFBFEDAFEFACDDCAECEAEBBECBAACADDCBEAFFBCFAFBBAFCDDCEBCAEFEFBABFCBFDDAEFDBFCDFDACFAAAFCECEAEDDBFFBBBEBAAAAADABEDEEBCECCBCBCEEBECDCFDCCDEADFBDACAFFAADCBDAEEABEDBBADAEFCBBAEFEDBBFEAADFAFBABADBBDCDECCDAEBFACDDEECEEBEFFBCEAEDEBDEACCFAEDDDFADCCFDFACFECEFDDCCEECBFDABDFDCBEDDABEFFCDDEDCEBEFAEBFCFBEACCDABDDACBEFBCFCEEEEFEBABBEFCAEEECEBBDBEBDDABEBCCABCFFCDBBAEBBFAABCEBADCCEEADBBEBCCDBAAAFBFBCFFACCFFFDDBFAAEBACACFEBEDACAABAEECFCAABCDABBCEDADFFAABBDDBFDCFEEFADBCCBDAAFCFCBEAECEBFFEDDFCBCCFDEEAABCDFEBFEACDAFCCDCFBCDDAEDFBAAFBCDFFBAAFBCEFAFCBEAEECEDDBBDFFDAFBBFFECAFDAAFDCFDCBBBFCEDCFADFAEEDFEFDCCACACAACCBAEDFDDBEECFDEBFCACBDACBAFFCCEDBBEECBACFCDBEEBAADBCABCFFAFFCBABDBEBCDDEEDEBBDECAEEEBFFFEDFDFECEAFAADDAEAAAACBBDFFACAFFEEFAECDDFDBCBCDEFDFFDDACEEBBFDBBEBAEFDACEEEACAFACCBDFEABEDCADFCFFEEBFFBFAEAFBDEDABEACADEACDDADCCFBCDBFCBDCADBFBBBFECCCEBFDEDEEDBCDCBEEBCEFFEADDFDCABAAEAFCAEACCBDFCEECDCFCABCCDDAFDFACCCFBDCFFFDDBAFCECCCBFCAECABCBFEEDADCFFCFBDAEEDBCABBCFFDBCECBAABEEFFDDAFDEBAAFBDBDEEBACFAEBEECFAEDDFDBBFEDACBADECEBCFCCFCCBEEEBCCFFFEFFAEDBECAFBFBFDDFEBDCECAFFCCBAECCAAFEDDDAFAABADBAFEDAFFEEAFFFBEFBEADEDDFAFEBDFAEBCDDFBCFEEAFDDAAFAAEACBCEACBCBEECFAAEFBBBEFDBBDDCEBBABFEFCABEBDAFDDDFDCCFFFECDFACCAABCDABDABFFBACBAADDCEBBBDFEEFAAADEEEFEDDDFCBCDFDFEFCEEFCBCAEFFCEDAADBDEFEABBEEDBFBECDCACAACCAAAFCEFBBCCEADBFBCFCCCEFABBDADBACACDABBADAFDECFBDABDEBEBFDFCBADAEDFCFFCEDEBBADFDBCFFBFAFDCFEADFFAEDFEBDCCEAABDBDCADABACCAAFEDDFCADAFDFADDCEEAFAAACAFCAAAFEBDBEBACCABCBFCCBCEDADAEAFDAEFDEABCACCCECFDFFCAEBCECAEEDFFEDAEFEBCAAECCFBDDACABCBCEBBADCDDECDBBEFAFCDAFBEDCEDBAEBCADEDFFEECEFDDEFCBBBBEDBBBBCBAEFDDEBDBCCEAAAFADEFACFBABCCFDCBBADCBAEEEEBAEAFCEEFBCFCBFEFDDCBDCDCEAFEAADEEADAEFBBEDBBCECABFCCEBADECACDAECEBECBAAFCBEABCBDFECDECFDBAFDBCBDFEDBEACDBDEBEABFBBEDDBAFBACCDEABDBEDEEFEDDDCDACEBEDBBBFBEFFBCAFBAFFAEAFACCFDFDFCBCDAABDFBBECBFFAABCFCFCAEEBFCCDFFEFEADBCDDDFCEDBFEABDDFBCBEABECBCCACCCCABAAFCABCAFFCCCFCBBEFEEBEECEEBDDEBABAFFEAAADACDFDBEAABFAECADAEBFFBECBEBCEEEBFEAECEEFAFAEFCDECDECFEBFFBAAFADCAAABDBCDABCAAAFBAEDEFFEDABCDBBECBCCDEFBDACFFBFCEAEFBDCADAEEDCBFEDAEEDBBFFFCFEDFDDAADDCAECBBECDDDFBAFEABFDBBBEEDBFAFAADFDCFCBEAFAEBBDDFDFFCBBCFCCBCCEBAFBAFDEAFCAFFCBDDABDFDBAFDEADCBDFCAACAEEFDEABAEDAFBBBFDACBDABFBFBEAEEFEFCCDCECAECECEABBEFABDFAFDABBDFEFFCBDFCFFEEBBFEDFCADDBEADFFDDACCDCDEBADDABBDADAFCACAEDFDFFDCABAABCCEBDEAFBDCBECFFCAAABBECDBFDFBDEDCACDEAADCDFEAEBBBADFECECEAEBEBFDCABEDDBEECEEDFCEDDADAEBCEEDBAFDFACDEDDABDEBDDDAECBFEFCEEDBBBEBADFFCABDFABFBBFCABFFCCADFCBFBABCDFFDCFBACBCCBBDCDCABFDAFBCFAFBDAFAACBFACCCDBEDFADFEEEDCADEFFFDDCECADEFCDEDCCDDFEDFEBCBCABDDFEADFDFFECFFCCBCABEFBDBDAEDACBBFFBDFEEEACDEBDFFCDEFEBFBBEFABBDFDADDBACEEEBAEECEDACCCDDDFBCEEECCDAEDCCCDBCEBDDADAACCFAEEDFBAEECACFFDEBADDDAABBCDACEEBEAFCADEAFFDBAFFEDAFECCAAEBAFACACEDEBCFFFFDEDDEAFEBCEFDCBCBCBCCBADBAACFDFFBFDABDACCBFEEADFECBBCAFCFDADAACFDBAAAEEACCDAFFCFBCAFBDBAECCCFBDFBFCEBEABFEADAADAEAABEDDACBCCDBAFCCFEAAFBBBBFFCBADEBDECFCCADDCCFFBEDCAADDDFDCFBABBEBBFFDDDBCDBCDDAEDFDBCADEDDECBAAAFCDACDEAAEFEACEBCEEAEBEFCEDEDCAAAFBFCDCEFFBCFDCBAFEDACCBFFAFCBADAEFDBDFAABABDCDABDEAAFEBFFCFABBDECEDDBECEEACCDBEEAEBEECDBBBDEEADFDEFDADDBAACBCCDCCFCFEFEBCDABEFBABCDCBFDAACDDFCCFACEBDCFEABACFEBAFECEAABFFDBFFFDACEAECBFDECFDAFCECEBCBFFAEDBEEDFDEBBBCFFEBFFDDCDBDFCCBADCDDBDEACEEDDBECCEFDAFEAABCEDFAEAFCEFDAAECEFDEDDBACDBDFCAECBEFEDADBBBDFFADDCCADBFBAECBACDDBEFDCEDBCFDDFCAEDBCBBDCFBDACFBBEEECFCEBFCFDCAACBBEBEACFCCECCCEFEAEBEBADDACCFCFBCADEEBCBDBFAAFEFBFBBAFAACDDFFBDCECAABEAADAEDCECDEDADFBEACDBBEAACDAABEEDBDADCACFEEABBCBFEDDCDBFDCADCABBECBBCCBDBFEBEBFCCEDBFABDCFFFECFCEEFFBECCCAAFBCBDBDDADCFCEDBEEDAEBCABDFEDFACBFCBEABEFCDBDCFACBBACDFEBCCDBBBCFEADACAEDCCFEAECDAACAFFDFFABFBDCBAEBABDBCFABAAFEFECBAFBCEDCFEAFEDCBCCDDDCEBDFADCEEBABBFAEEACADCABCFAFBBEAFDFBDABBCECAEFEDACCCAEFFACCDADACCFAFEBABACFEFACCAACFFFDCDDDADCEEAABEEBBEFFFBFEECFEBCBFDEBDAAFCBFABFFCBDBDEADACEACBCDCEEFABAFBDDADDADDDAEBDDABBEAFDEDFDACCCFEBCACDDEFBBDACCBCACBDFFCFAABEFFDBFAFDADBDFEFABEFFFCBDEBFDBEECDACFEDCBFDBFEABEEEBADBADDFEAECBCEBAEABBBEEFDCEFBDEADCFBBAFEACBDEDAAEBDABBAAFCBDEFDEABCAFCDECABFDAFBEEDDECBCABBACFEBBACEEEFADEDECFBABECECEBCABAAFBFDADFDEDCBEEAEEAFBFFCCAACCEBCBEEBBABBDAEBDBBEFDEDCABEAAADFCDFDEDFBFDFFDEEEBEACBDDDFDCACAAABBDBFDCDEDFDDFBDDABEFFBCCDFFAFAACCEACEFAEFFCBBEECCBDEADCDBDADEACBFFDFDFDACFDABBEFFDFEDEDEEACDFEEBFCBBDADAEEFFFBFDACBFDBBBDDDDCDFECBDBFAFDEEEDBFDBDEFAFEFDACBEDDAAEBEDCFCABFDAADFEFBACCEBEECECDDBCCDECFEABABEEDDAEBEDCEBABEBBFAEEBCEDEFCDBEEBBCBCEEEEFFFFEDFABFBDECFFFDDBDFCCDBFFDDDEDEBAEFABFCDEDCCDEBBAECCAEEFFFEFCACACDEECBBBBEFBAEFAAFBBCDABEDEEECBDDCFEDAFCFFEAAFEEFBFDCBDDEDBEFECBDFEBFEBDFDEEBCAEBDFDFAEAACEADCCECDECCDFAAFBCEDFEFAEDCFFDAECDAAEBEFEFDCBDCCDCDADBEDECADBBCBEBBABEDEEDEDBBAABCCBBABADEADFCCFDBCACAAFAFCDDFDFFAAAFDFFBDDEFAFFFCAEEEFFACECEDDEDCEFACFEDBDDFABEBFCEBECFFACACAFFBDBCBDBFCEFBDFBEFAEDFCFBCDCCABFEABECFCACBEFFAEAAAEDBFAAEDECBBBEAFDCACDCFDAFCECBCBCCEFFDCACDEEADAADDACCDAFECDFAEEFCDBAEAFFCDBADDFAAFACFEDDADBDFECAECBCFCAEACDDFEABFFEDADCECDFADFCBDFAFCFFEFECABACADCFCCFCDFDFBBCEFDACBBCCDDBADEDDFBACFFAFBBFBECBCCFEBCFABBBDCCCBDBEBDDCBBDFDDBEFCDADAECDEBFDCEDEBBECAABABEDAAECAEEFFDDFBCADCFFCAFCFECFCEBFDECBEEBCCFCCACFAFEBBADAEECCEEECBBDAEEEDCCDCECAEFBAFDABBECFDFBDEFDFAFDEABEFBAAAACCEAFEFABAAEEAAFABFAACBDCCBDFCEBBECECFEBCEBEFACCFEEBDBAEBDAAFBFFBADADECCABFEEABADEFBBFFEFCFFDEEDECAECABBBAFAFDCFCDADACACDDDBFADBDCEADEAAAACDBDADCCEEEBBFADAEEEDABDCEACBBEFEFEADBDEABEEFABDAFBFAEBBDDFCECECDFBEBFBFBCCBABBBAFDBECBADBACDBAACDEBDFFEDEBCACACADBCFEEDDCFBCABACAADCDAAFEADEDDBCCDFFFCAEAFBEBBCEFCEABCCEBBAAFCCDDFDEBEAECEEADDADFDFADDAABDCADEDDAACFCFADDCEDBDCAEFACFBDADECCCFDEFFDCADDEAACFCCEADCAEECCBAABFBDFADDDBBFDDCAEDDBFCCEBFADFBAFCBEECEAFBFADEBCCADCAAEDCCCFACECDADFAEDEBDDAADBBEECEEFEFEEBDBBBACBBBEEFECEFDAAFEDECCAEABCBCAFBFABFBAFDCDEFDDFFCADBDABFEFCCBDEEFBEDDBABACABBAABCBCBCEDAAABFABFDFAACCFDCDFFCFBAFCFDECEBBBBCFEAFABDEDEBECCCDBEABAAAFFEBAFAEDDBEFAFCBAACCABDCCCEFADFCAEFBFABBBECFCCFDCFDDCECFFCBDACCDACDEAEDFCDADCDDCEBCBEBDDAEBBEDDDCBBEBADECCFEAABFDDFECCCCCDEADFBAACCBAEADBDADFABCDDCECDFEDBFFBDFDAEECDBBAABAAFBECFCDDCBFDBFACDBACAFEBFBFFEEDBEABEFEBABDFBBDDEDFABBDBFAFBEAFAEDCABCFCDEFABAFDDABBDAADCEBACEAEADBEBCBBDAFABCEEEADFCABFFCBFCBACEBEACEAABDCCAFFDABFADDCFBDDAFFABAEDADFFBCBABDCDEACCDAAADEAEDEBFDDBADDBACDEABFFCAEBEBDCFDABACECFBBFBEACCDACBDBCEECFFAECEBADEDDFBEEACECBAFDBFFAFBBDCCCEACEEACFABECDBBAAFCDABFADFFACCFDECAFDCEFDDBDFBAFAEBEFEADFCFBDEBCACDBEFDEBAACCADFDDFEDEABBDDAEEADEBDFEBAFDCBCBABCDBAFBCDDEEDDCCEAFFCCADAEDFCAFABEDFECFBBAEEABBDBECCCCCEABFFFBBBFBEDDDEAFFFEAEFFDAADDEABEDDFDBBEFABFECFEECCCCDBAECFCEACEDEBAFCCFDEDCFCCDBDEBCCFBFACCDDAFFBCDEAFEEDCDABBFEAADDECDBFBBFAEDAACABEFFFFECFADEEAEDEEEDFFBCBFABEDABBDBBEDBFEEAAACFFDBBDEEBBBDDDCCEBBCDDFEEFDFBFCBCEFEDCEFFECCBDEEFFECABFACBFCFFEFAECDEABAFECEDEEBAFBBCFFBDAACFBCBFBEFABBBCECCDAACBFBAEABCBBEFEFCDDBBAEFEFBDBAECDBCEAFECEDDECAFAEABCCEAAEACEFFFADDCDEBFDAAACFCCEBEBABCFBDDEECEDBFFFADBDFABDFFCEDCAAEFCDCFECBBCCCDAAABDBAECBABDABEAAFABBFFCDECFCAEFCAFEECBFCAEDCFFDBBFDEBBCBCFBFFFFFECDBEFDEEDFBAFADBBBFFEEFFECFEEEDABBCBDEDEFDCBEBCCAEFFADDAAECCEFEFCFADBAADAFDEBBEECABDEEDCEBCABFBCECDDCCDBBABDABCEDBDCBBDDACECBDEFBEEEEBACBBADFDBACDCDCEBFDEBDAAFCDDBCCCBACAECCAADFBCBACBFBDFFCCCAFBBBBACEFABBEFAAFFDCEEDDDDFBBBADDEEDFBFADCDBDAAAEEFAFFAFCAACFCCFFDAFFCCDCECDEBADACCFFEBCAFAAFBB";

$start = microtime(true);
$solution->s1($long, 4567);
echo round(1000 * (microtime(true) - $start), 3) . "ms\n";

$start = microtime(true);
$solution->s2($long, 4567);
echo round(1000 * (microtime(true) - $start), 3) . "ms\n";