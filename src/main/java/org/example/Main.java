package org.example;
import Handlers.CreditHandler;
import Handlers.DebitHandler;
import Handlers.DepositeHandler;
import Handlers.Receiver;

/**
 * Лабораторная работа 1
 * Банки
 * Предметная область
 *
 * Есть несколько Банков, которые предоставляют финансовые услуги по операциям с деньгами.
 *
 * В банке есть Счета и Клиенты. У клиента есть имя, фамилия, адрес и номер паспорта
 * (имя и фамилия обязательны, остальное – опционально).
 * @author Бритикова Элиза
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Receiver receiver = new Receiver(false, true, true);

        CreditHandler CreditScore = new CreditHandler();
        DebitHandler DebitScore = new DebitHandler();
        DepositeHandler DepositeScore = new DepositeHandler();
        CreditScore.setSuccessor(DepositeScore);
        DepositeScore.setSuccessor(DebitScore);

        CreditScore.Handle(receiver);

            }
        }