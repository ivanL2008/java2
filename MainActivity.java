package com.example.java2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    // задание полей
    float apartmentPrice = 14_000; // стоимость телескопа
    int account = 1_000; // счёт пользователя
    float wage = 2_500; // стипендия в месяц
    int percentFree = 100; // доля степендии на любые траты
    float percentBank = 5; // годовая процентная ставка за счет
    float[] monthlyPayments = new float[120]; // создание массива ежемесячных платежей на 10 лет

    // метод подсчёта выплоты денег с учётом первоначального взноса
    private float apartmentPriceWithContribution() {
        return apartmentPrice - account; // возврат подсчитанного значения
    }

    // метод подсчёта ежемесячных выплота денег (стипендия, процент своб.трат)
    public float mortgageCosts(float amount, int percent) {
        return (amount*percent)/100;
    }

    // метод подсчёта времени выплаты денег (сумма выплота, сумма платежа, годовой процент)
    // и заполнение массива monthlyPayments[] ежемесячными платежами
    public int countMonth(float total, float mortgageCosts, float percentBankYear) {

        float percentBankMonth = percentBankYear / 12; // подсчёт ежемесячного процента банка за вклад
        int count = 0; // счётчик месяцев выплаты денег

        // алгоритм расчёта выдачи
        while (total>0) {
            count++; // добавление нового месяца
            total = (total + (total*percentBankMonth)/100) - mortgageCosts; // вычисление счета с учётом выплаты и процента
            // заполнение массива ежемесячными платежами
            if(total > mortgageCosts) { // если сумма долга больше ежемесячного платежа, то
                monthlyPayments[count-1] = mortgageCosts; // в массив добавляется целый платёж
            } else { // иначе
                monthlyPayments[count-1] = total; // в массив добавляется платёж равный остатку долга
            }
        }

        return count;
    }

    // создание дополнительных полей для вывода на экран полученных значений
    private TextView countOut; // поле вывода количества месяцев выплаты ипотеки
    private TextView manyMonthOut; // поле выписки по ежемесячным платежам

    // вывод на экран полученных значений
public class Mainactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}