package test1;

import org.junit.Test;

import static org.junit.Assert.*;

public class Algorithm376Test {

    @Test
    public void wiggleMaxLength() {
        Algorithm376 test= new Algorithm376();
        int[] nums={1,1,7,4,9,2,5};
        System.out.println(test.wiggleMaxLength(nums));
        nums=new int[]{1,7,4,9,2,5};
        System.out.println(test.wiggleMaxLength(nums));
        nums=new int[]{1,2,3,4,5,6,7,8,9};
        System.out.println(test.wiggleMaxLength(nums));
        nums=new int[]{1,2,3,4,7,5,2,3,7};
        System.out.println(test.wiggleMaxLength(nums));
        nums=new int[]{1,1,1,1,1,1,2,3,7};
        System.out.println(test.wiggleMaxLength(nums));
        nums=new int[]{138,212,258,600,246,468,309,497,548,415,346,249,346,399,411,414,459,545,549,580,147,328,120,521,190,593,494,74,102,21,364,554,438,406,475,222,513,60,284,499,332,78,29,441,26,564,123,476,200,210,552,323,351,463,399,354,129,140,31,520,263,119,0,208,307,579,285,237,18,161,151,230,73,54,188,408,238,228,212,414,167,405,117,171,301,567,12,439,109,450,540,403,226,192,146,467,211,483,333,144,471,78,600,439,267,30,189,138,554,564,453,133,224,159,424,23,265,424,457,104,263,40,404,176,56,296,452,421,282,495,23,525,145,55,29,345,457,58,117,128,127,171,570,534,86,222,184,393,414,334,177,514,283,255,544,236,62,163,374,33,466,46,52,596,598,280,439,432,363,454,98,270,517,448,592,475,515,307,124,435,304,256,390,246,19,232,495,172,201,278,279,165,175,284,552,27,166,344,7,337,201,374,257,204,7,404,458,499,497,564,276,344,115,168,454,405,64,196,383,150,184,464,436,51,499,197,439,26,303,232,393,286,172,222,467,110,517,389,569,491,190,379,420,244,161,39,286,426,14,67,550,542,301,46,229,284,239,312,360,267,40,404,213,118,412,452,63,188,506,116,87,301,100,318,350,254,399,7,450,288,505,380,417,265,517,274,388,166,159,474,234,494,338,371,582,200,171,257,348,596,533,31,438,97,488,384,232,553,595,396,271,242,489,24,498,515,290,160,487,386,66,216,369,327,599,352,586,155,203,386,215,253,410,544,290,379,463,152,503,64,341,182,263,228,546,108,555,161,553,49,153,557,487,257,505,443,583,395,47,460,295,93,578,160,104,67,383,295,209,329,550,510,428,326,148,498,222,286,506,347,56,125,231,406,60,243,585,515,147,54,72,487,146,459,260,85,591,11,527,37,356,156,273,301,306,422,377,391,213,459,346,127,7,151,12,390,348,69,189,510,329,148,18,126,587,220,271,526,62,326,542,414,478,442,332,338,522,99,382,406,313,340,318,443,348,451,510,345,480,308,325,169,492,237,571,212,423,74,133,169,329,418,353,180,325,354,175,534,44,125,90,222,46,49,477,226,226,155,144,90,417,347,113,564,306,227,196,118,356,447,348,96,197,21,330,255,474,366,546,158,594,153,64,266,52,22,18,47,304,572,154,17,258,209,390,162,386,357,379,26,379,456,538,549,248,438,534,327,26,500,339,474,146,564,14,348,142,168,242,538,113,469,394,578,101,527,67,281,138,504,401,526,513,566,377,132,257,45,167,549,461,425,127,120,39,165,239,181,583,444,180,61,543,179,355,52,495,304,312,247,575,236,546,527,10,504,424,587,128,473,61,11,38,28,599,73,387,447,75,300};
        System.out.println(test.wiggleMaxLength(nums));
    }
}