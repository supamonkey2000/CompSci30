import java.io.ObjectInputStream;
import java.util.concurrent.ThreadLocalRandom;

class Challenge3 {

    private LinkedList baseDeck = new LinkedList();

    private void makeCards() {
        String[] titles = {"Ace","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Jack","Queen","King"};
        int[] scores = {1,2,3,4,5,6,7,8,9,10,11,12,13};
        for(int i = 0; i < scores.length; i++) {
            baseDeck.add(new Object[]{titles[i],scores[i]});
            baseDeck.add(new Object[]{titles[i],scores[i]});
            baseDeck.add(new Object[]{titles[i],scores[i]});
            baseDeck.add(new Object[]{titles[i],scores[i]});
        }
    }

    void war() {
        makeCards();
        LinkedList[] playerDecks = deal(selectionShuffle(baseDeck));

        System.out.println("\nLets play a game of war");

        war_loop:while(true) {
            System.out.println("");

            Object[] cardP1 = (Object[]) playerDecks[0].get(0);
            Object[] cardP2 = (Object[]) playerDecks[1].get(0);
            playerDecks[0].remove(0);
            playerDecks[1].remove(0);

            System.out.println("Player 1 played " + cardP1[0] + " and Player 2 played " + cardP2[0] + ".");
            if(cardP1[1] == cardP2[1]) {
                boolean war = true;
                LinkedList warCards = new LinkedList();
                warCards.add(cardP1);
                warCards.add(cardP2);
                //WAR
                while(war) {
                    if(playerDecks[0].length() < 5) {
                        System.out.println("Player 2 wins the game because Player 1 has no cards for War!");
                        break war_loop;
                    } else if(playerDecks[1].length() < 5) {
                        System.out.println("Player 1 wins the game because Player 2 has no cards for War!");
                        break war_loop;
                    }
                    for(int i = 0; i < 3; i++) {
                        Object[] card = (Object[]) playerDecks[0].get(0);
                        warCards.add(card);
                        playerDecks[0].remove(0);
                    }
                    for(int i = 0; i < 3; i++) {
                        Object[] card = (Object[]) playerDecks[1].get(0);
                        warCards.add(card);
                        playerDecks[1].remove(0);
                    }
                    Object[] card1 = (Object[]) playerDecks[0].get(0);
                    Object[] card2 = (Object[]) playerDecks[1].get(0);
                    warCards.add(card1);
                    warCards.add(card2);
                    playerDecks[0].remove(0);
                    playerDecks[1].remove(0);

                    if((int)card1[1] > (int)card2[1]) {
                        System.out.println("Player 1 wins the war!");
                        for(int i = 0; i < warCards.length(); i++) {
                            playerDecks[0].add(warCards.get(i));
                        }
                        break;
                    } else if((int)card1[1] < (int)card2[1]) {
                        System.out.println("Player 2 wins the war!");
                        for(int i = 0; i < warCards.length(); i++) {
                            playerDecks[1].add(warCards.get(i));
                        }
                        break;
                    }
                }
                //END OF WAR
            } else if((int)cardP1[1] > (int)cardP2[1]) {
                System.out.println("Player 1 wins the round.");
                playerDecks[0].add(cardP1);
                playerDecks[0].add(cardP2);
            } else {
                System.out.println("Player 2 wins the round.");
                playerDecks[1].add(cardP1);
                playerDecks[1].add(cardP2);
            }

            System.out.println(playerDecks[0].length() + ", " + playerDecks[1].length());

            if(playerDecks[0].length() == 0) {
                System.out.println("\nPlayer 2 wins the game!");
                break;
            } else if(playerDecks[1].length() == 0) {
                System.out.println("\nPlayer 1 wins the game!");
                break;
            }

            try{Thread.sleep(5);}catch(Exception ex){}
        }
    }

    private LinkedList[] deal(LinkedList deck) {
        LinkedList playerOne = new LinkedList(), playerTwo = new LinkedList();
        for(int i = 0; i < deck.length(); i += 2) {
            playerOne.add(deck.get(i));
            playerTwo.add(deck.get(i + 1));
        }
        return new LinkedList[]{playerOne, playerTwo};
    }

    private LinkedList selectionShuffle(LinkedList startDeck) {
        LinkedList newDeck = new LinkedList();
        int size = startDeck.length();
        for(int k = 0; k < size; k++) {
            Object[] tmpCard = null;
            while(tmpCard==null) {
                int j = ThreadLocalRandom.current().nextInt(0,51);
                tmpCard = (Object[])startDeck.get(j);
            }
            newDeck.add(tmpCard);
        }
        return newDeck;
    }
}