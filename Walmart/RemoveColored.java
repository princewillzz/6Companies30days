class Solution {
    public boolean winnerOfGame(String colors) {
        int Aplays = 0, Bplays = 0, contA = 0, contB = 0;
        for (int i = 0; i < colors.length(); i++) {
            char c = colors.charAt(i);
            if (c == 'A') {
                contB = 0;
                contA++;
                if (contA >= 3) {
                    Aplays++;
                }
            }
            else {
                contA = 0;
                contB++;
                if (contB >= 3) {
                    Bplays++;
                }

            }
        }
        return Aplays > Bplays;
    }
}