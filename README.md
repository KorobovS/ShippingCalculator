# Домашнее задание
## Задача. Вам нужно написать функцию расчёта стоимости доставки.
### Стоимость рассчитывается в зависимости от:

_расстояния до пункта назначения:_
- более 30 км: +300 рублей к доставке;
- до 30 км: +200 рублей к доставке;
- до 10 км: +100 рублей к доставке;
- до 2 км: +50 рублей к доставке;

_габаритов груза:_
- большие габариты: +200 рублей к доставке;
- маленькие габариты: +100 рублей к доставке;

_хрупкости груза._
Если груз хрупкий — +300 рублей к доставке.
Хрупкие грузы нельзя возить на расстояние более 30 км;

_загруженности службы доставки._
Стоимость умножается на коэффициент доставки:
- очень высокая загруженность — 1.6;
- высокая загруженность — 1.4;
- повышенная загруженность — 1.2;
- во всех остальных случаях коэффициент равен 1.

Минимальная сумма доставки — 400 рублей. Если сумма доставки меньше минимальной, выводится минимальная сумма.

На входе функция получает расстояние до пункта назначения, габариты, информацию о хрупкости, загруженность службы на текущий момент. На выходе пользователь получает стоимость доставки.

## Что нужно сделать:
- напишите код-решение для этой задачи;
- покройте свое решение юнит тестами JUnit 5. Ответ приложите в виде ссылки на репозиторий;
- нужно использовать аннотации @Test, @Tag, @ParametrizedTest, @DisplayName.
- нужно использовать assertEquals, любой другой assert.
- настроить Allure отчеты и приложить скриншот пройденных тестов;
- задание со звездочкой: посчитать процент покрытия используя Test Coverage. 
