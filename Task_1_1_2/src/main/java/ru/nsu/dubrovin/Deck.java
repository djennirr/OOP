package ru.nsu.dubrovin;

import java.util.Collections;
import java.util.List;

public class Deck {
    Card[] deck = new Card[52];
    List cards;

    public Deck() {
        String[] names = {"Единица", "Двойка", "Тройка", "Четвёрка", "Пятёрка", "Шестёрка", "Семёрка",
                "Восьмёрка", "Девятка", "Десятка", "Валет", "Дама", "Король", "Туз"};
        String[] types = {"Черви", "Пики", "Бубны", "Трефы"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1};

        for (String type : types){
            for (int i = 0; i < 11; i++){
                deck[i] = new Card(names[i], type, values[i]);
            }
        }
        cards = List.of(deck);
        Collections.shuffle(cards);
    }

    public Deck(List<Card> cards) {
        this.cards = cards;
    }

    public Card draw() {
        return (Card) cards.remove(cards.size() - 1);
    }
}
