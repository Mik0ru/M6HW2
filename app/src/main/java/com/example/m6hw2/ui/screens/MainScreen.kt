package com.example.m6hw2.ui.screens

import androidx.compose.foundation.clickable
import com.example.m6hw2.data.BookModel
import com.example.m6hw2.ui.activity.CustomNavController
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: CustomNavController) {
    val textState = remember { mutableStateOf(TextFieldValue("")) }
    val searchQuery = remember { mutableStateOf("") }
    LaunchedEffect(textState.value.text) {
        delay(300)
        searchQuery.value = textState.value.text
    }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val detectiveBookList = listOf(
            BookModel(
                "Записки о Шерлоке Холмсе",
                "Артур Конан Дойл",
                "Новые захватывающие приключения Шерлока Холмса и доктора Ватсона! Семейные предания, жажда богатства, тайны, которые нужно во что бы то ни стало сохранить… Знаменитый сыщик раскрывает невероятно запутанные дела и бесстрашно вступает в схватку с величайшим злодеем своего времени...",
                "https://cdn.azbooka.ru/cv/w1100/d6a2435a-9271-4f8c-90d2-f46aa2767560.jpg"
            ),
            BookModel(
                "Азазель",
                "Борис Акунин",
                "первый роман из серии о необыкновенном сыщике Эрасте Фандорине. Ему всего двадцать лет, но он удачлив, бесстрашен, благороден и привлекателен. Юный Эраст Петрович служит в полицейском управлении, по долгу службы и по велению сердца расследует крайне запутанное дело. Книги об Эрасте Фандорине насыщены информацией из истории Отечества и одновременно являются увлекательнейшим детективным чтением ",
                "https://upload.wikimedia.org/wikipedia/ru/6/60/Azazel_%28book%29.jpg"
            ),
            BookModel(
                "Девушка с татуировкой дракона",
                "Стиг Ларссон",
                "Сорок лет загадка исчезновения юной родственницы не дает покоя стареющему промышленному магнату, и вот он предпринимает последнюю в своей жизни попытку – поручает розыск журналисту Микаэлю Блумквисту. Тот берется за безнадежное дело больше для того, чтобы отвлечься от собственных неприятностей, но вскоре понимает: проблема даже сложнее, чем кажется на первый взгляд...",
                "https://upload.wikimedia.org/wikipedia/ru/a/ac/The_Girl_with_the_Dragon_Tatoo.jpg"
            ),
            BookModel(
                "Дурная кровь",
                "Роберт Гэлбрейт",
                "Корморан Страйк навещает родных в Корнуолле. Там к частному детективу, вновь попавшему на первые полосы газет после того, как он поймал Шеклуэллского Потрошителя и раскрыл убийство министра культуры Джаспера Чизуэлла, обращается незнакомая женщина и просит найти ее мать, пропавшую при загадочных обстоятельствах в 1974 году. Страйку никогда еще не доводилось расследовать «висяки», тем более сорокалетней выдержки; шансы на успех почти нулевые. Но он заинтригован таинственным исчезновением молодого доктора Марго Бамборо и берется за дело, которое оказывается, пожалуй, самым головоломным в его практике. Со своей верной помощницей Робин Эллакотт, успевшей стать в их агентстве полноправным партнером, Страйк разыскивает неуловимых очевидцев и опрашивает ненадежных свидетелей, ищет подходы к сидящему четвертое десятилетие за решеткой маньяку-убийце, с отвращением осваивает гадание по картам Таро и астрологические премудрости — и постепенно убеждается, что даже дела настолько давние могут быть смертельно опасны… ",
                "https://basket-13.wbbasket.ru/vol2043/part204352/204352757/images/big/1.webp"
            )
        )

        val classicsBooksList = listOf(
            BookModel(
                "Цветы для Элджернона",
                "Дэниел Киз",
                "32-летний Чарли Гордон умственно отсталый. Ради мечты стать умным он соглашается принять участие в опасном научном эксперименте. Изменения с Чарли происходят на наших глазах. В первых отчетах полно орфографических ошибок, ему трудно излагать свои мысли. Постепенно Чарли начинает писать грамотнее и по-новому смотреть на мир...",
                "https://upload.wikimedia.org/wikipedia/ru/6/6b/%D0%A6%D0%B2%D0%B5%D1%82%D1%8B_%D0%B4%D0%BB%D1%8F_%D0%AD%D0%BB%D0%B4%D0%B6%D0%B5%D1%80%D0%BD%D0%BE%D0%BD%D0%B0.jpg"
            ),
            BookModel(
                "Маленький принц",
                "Антуан де Сент-Экзюпери",
                "Книга \"Маленький принц\" Антуана де Сент-Экзюпери впервые вышла в 1943 году и с тех пор завоевала сердца читателей во всём мире. Книга-притча, философская сказка о маленьком мальчике, который путешествовал по разным планетам и в конце оказался на нашей Земле. Главные герои - сам принц, его друг лётчик, красавица-роза, мудрый Лис - расскажут читателям об ответственности за тех, кого приручили, о жизни и о великой любви и дружбе",
                "https://imo10.labirint.ru/books/821515/cover.jpg/484-0"
            ),
            BookModel(
                "1984",
                "Джордж Оруэлл",
                "Детство Уинстона Смита пришлось на 1950-е годы, когда в результате революции к власти в Великобритании пришла партия английского социализма. Отец и мать бесследно исчезли. Уинстон не знает, что произошло с его родителями — либо они были распылены, либо приговорены к длительному заключению в концлагере. С молодых лет Уинстон работает в министерстве правды, в его обязанности входит правка документов, которые содержат факты, противоречащие партийной пропаганде. Смит осознает, что испытывает сомнения по поводу идеологии своей партии, но на людях ему приходится притворяться приверженцем английского социализма, так как высказывать любые идеи против партии опасно. Возможно, Уинстон и дальше спокойно жил, втайне записывая свои мысли в дневник, если бы не встреча с Джулией …",
                "https://imo10.labirint.ru/books/871428/cover.jpg/484-0"
            )
        )
        val romanticBooksList = listOf(
            BookModel(
                "Гордость и предубеждение",
                "Джейн Остин",
                "Классический роман о любви и социальных предрассудках, который рассказывает историю Элизабет Беннет и мистера Дарси, их недоразумений и глубокого чувства, преодолевающего все препятствия.",
                "https://bookhouse.kg/media/galleryphoto/2023/4/2e4f2c1b-89cf-4c39-b225-af620bc905ba.jpg.600x780_q94.jpg"
            ),
            BookModel(
                "Унесённые ветром",
                "Маргарет Митчелл",
                "Исторический роман, разворачивающийся на фоне Гражданской войны в США, повествует о жизни Скарлетт О’Хара, её упорстве, любви и потере.",
                "https://cdn.azbooka.ru/cv/w1100/788c5aa9-b703-48b8-9d79-251756aedbff.jpg"
            ),
            BookModel(
                "Дневник памяти",
                "Николас Спаркс",
                "История великой любви, которая не подвластна времени, рассказывает о Ноа и Элли, чьи чувства выдерживают испытания временем и судьбой.",
                "https://static.insales-cdn.com/r/g_t4KC_o-4g/rs:fit:1000:0:1/q:100/plain/images/products/1/4725/660910709/1.jpeg@jpeg"
            )
        )
        val scienceFictionBooksList = listOf(
            BookModel(
                "Пикник на обочине",
                "Аркадий и Борис Стругацкие",
                "Рискуя жизнью, сталкеры добывают из Зоны артефакты — не более чем космический мусор, оставленный пришельцами на Земле подобно тому, как после человеческого пикника на обочине дороги остаются пустые бутылки, банки и упаковки. Никому точно не известно, для чего предназначены эти артефакты, порой несущие огромную опасность. Каждый сталкер мечтает дойти до Золотого Шара, который может выполнить самое сокровенное желание.",
                "https://upload.wikimedia.org/wikipedia/ru/3/31/%D0%9F%D0%B8%D0%BA%D0%BD%D0%B8%D0%BA_%D0%BD%D0%B0_%D0%BE%D0%B1%D0%BE%D1%87%D0%B8%D0%BD%D0%B5_%28%D0%BE%D0%B1%D0%BB%D0%BE%D0%B6%D0%BA%D0%B0_%D0%BA%D0%BD%D0%B8%D0%B3%D0%B8%29.jpg"
            ),
            BookModel(
                "Дюна",
                "Фрэнк Герберт",
                "Эпическая сага, действие которой разворачивается на планете Арракис, единственном источнике самого ценного вещества во вселенной — пряности. Пол Атрейдес вступает на путь своего предназначения, который изменит судьбу галактики.",
                "https://imo10.labirint.ru/books/741877/cover.jpg/242-0"
            ),
            BookModel(
                "Марсианин",
                "Энди Вейер",
                "Роман о выживании астронавта Марка Уотни, оказавшегося в одиночестве на Марсе. История о находчивости, науке и борьбе за жизнь на чужой планете.",
                "https://static.insales-cdn.com/r/JQdD7fBkYhs/rs:fit:1000:0:1/q:100/plain/images/products/1/7132/579771356/cover1__w6008772a5801b67bf17.jpg@jpg"
            )
        )
        val horrorBooksList = listOf(
            BookModel(
                "Сияние",
                "Стивен Кинг",
                "История Джека Торренса, который устраивается на работу смотрителем в отеле «Оверлук». Но вместе с его семьёй отель начинает раскрывать свои мрачные тайны и оборачивается кошмаром.",
                "https://globus-online.kg/upload/iblock/0fe/0fe00a663c3cb1e79fa428b767c58bda.png"
            ),
            BookModel(
                "Дракула",
                "Брэм Стокер",
                "Классический роман об охоте на графа Дракулу — могущественного вампира, который пытается перебраться из Трансильвании в Англию, чтобы обрести новые жертвы.",
                "https://imo10.labirint.ru/books/830269/cover.jpg/484-0"
            ),
            BookModel(
                "Призрак дома на холме",
                "Ширли Джексон",
                "История о группе людей, которые приезжают в старинный особняк, чтобы исследовать паранормальные явления, но сталкиваются с ужасом, выходящим за пределы понимания.",
                "https://imo10.labirint.ru/books/733574/cover.jpg/484-0"
            )
        )
        val genresList = listOf(
            "Детективы" to detectiveBookList,
            "Классика" to classicsBooksList,
            "Романтика" to romanticBooksList,
            "Фантастика" to scienceFictionBooksList,
            "Ужасы" to horrorBooksList
        )

        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Книги",
                    fontSize = 36.sp
                )
            }
        )
        SearchView(
            state = textState,
            modifier = Modifier
                .fillMaxWidth()
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, top = 16.dp, bottom = 36.dp),
        ) {
            items(
                items = genresList
            ) { (genreName, books) ->
                Text(
                    text = genreName,
                    fontSize = 24.sp,
                    modifier = Modifier
                        .padding(top = 24.dp)
                )
                if (filterBooks(books, searchQuery.value).isEmpty()) {
                    Text(
                        text = "К сожалению, ничего не найдено...",
                        fontSize = 16.sp,
                        modifier = Modifier
                            .padding(top = 16.dp)
                    )
                }
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, top = 16.dp),
                ) {
                    items(
                        items = filterBooks(books, searchQuery.value)
                    ) { book ->
                        BookItem(book, onClick = {
                            navController.navigate(Screens.Detail(book))
                        } )
                    }
                }
            }
        }
    }
}
@Composable
fun SearchView(
    state: MutableState<TextFieldValue>,
    modifier: Modifier = Modifier,
) {
    TextField(
        value = state.value,
        modifier = modifier,
        placeholder = {
            Text(text = "Поиск")
        },
        onValueChange = { value ->
            state.value = value
        }
    )
}
fun filterBooks(books: List<BookModel>, query: String): List<BookModel> {
    val filteredBooks = books.filter {
        it.title.contains(query, true) || it.author.contains(query, true)
    }
    return filteredBooks
}
@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun BookItem(book: BookModel, onClick: () -> Unit) {
    Row(
        modifier = Modifier
            .padding(end = 24.dp)
    ) {
        Column(
            modifier = Modifier
                .height(120.dp)
        ) {
            GlideImage(
                model = book.imageUrl,
                contentDescription = "image",
                modifier = Modifier
                    .clickable {
                        onClick()
                    }
            )
        }
        Column (
            modifier = Modifier
                .padding(start = 16.dp, top = 12.dp)
        ) {
            Text(
                fontSize = 28.sp,
                text = book.title,
                modifier = Modifier
                    .clickable{
                        onClick()
                    }
            )
            Text(
                text = book.author,
                modifier = Modifier
                    .padding(4.dp)
            )
        }
    }
}