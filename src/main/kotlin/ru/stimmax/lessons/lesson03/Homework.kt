package ru.stimmax.ru.stimmax.lessons.lesson03

class lesson03 {
    // 1 . Название мероприятия
    val name: String = "Monster Hackaton"

    // 2 . Дата проведения
    var date: String = "10 ноября 2025"

    // 3 . Место проведения
    val place: String = "SPB"

    // 4 . Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы.
    private val budget: String = "подробная информация с перечислением поставщиков и сумм для внутреннего пользования"

    // 5 . Количество участников
    var count: Int = 0

    // 6 . Длительность хакатона
    val duration: Int = 180

    // 7 . Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.
    private val contactInfo: String = "контактная информация"

    // 8 . Текущее состояние хакатона (статус)
    var duringTime: String = "00:00"

    // 9 . Список спонсоров
    val listSponsors: String = "список спонсоров"

    // 10 . Бюджет мероприятия
    private val budgetEvent: String = "2555.90"

    // 11 . Текущий уровень доступа к интернету
    var currentLevelOfInternetAccess: String = "0"

    // 12 . Информация о транспортировке оборудования, распределении ресурсов и координации между различными командами поддержки.
    private val info: String = "info"

    // 13 . Количество команд
    var numberOfTeams: Int = 0

    // 14 . Перечень задач
    val tasks: String = "tasks"

    // 15 . План эвакуации
    var evacuationPlan: String = "evacuation plan"

    // 16 . Список доступного оборудования (всё, что выделено для использования на мероприятии)
    val listOfAvailableEquipment: String = "List of available equipment"

    // 17 . Список свободного оборудования (всё, что можно взять прямо сейчас и что не занято другими участниками)
    var listOfFreeEquipment: String = "List of free equipment"

    // 18 . График питания участников (зависит от поставщика питания, определяемого за неделю до начала)
    lateinit var mealSchedule: String

    // 19 . План мероприятий на случай сбоев
    val emergencyPlan: String = "Emergercy Plan"

    // 20 . Список экспертов и жюри
    var listOfJudges: String = "list od Judges"

    // 21 . Политика конфиденциальности
    val privacyPolicy: String = "privacy policy"

    // 22 . Приватные отзывы (фидбэк) участников и зрителей для анализа проблем.
    private lateinit var privateFeedback: String

    // 23 . Текущая температура в помещении
    var temperature: Double = 24.0

    // 24 . Данные мониторинга и анализ производительности сетевого оборудования и интернет-соединения для целей отладки своих приложений командами
    var monitoringData: String = "info"

    // 25 . Регулятор скорости интернета (понижающий коэффициент, например 0.5)
    val speed: Double = 0.5

    // 26 . Уровень освещения
    var lightLevel: Int = 5

    // 27 . Лог событий мероприятия
    private lateinit var logEvent: String

    // 28 . Возможность получения медицинской помощи прямо на мероприятии (да/нет)
    val getMedicalHelp: Boolean = true

    // 29 . Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.
    val evacuationPlanAndProcedure: String = "evacuation plan"

    // 30 . Регистрационный номер мероприятия
    val registratenumber: Int = 555

    // 31 . Максимально допустимый уровень шума в помещении хакатона.
    val noiseLevel: Int = 55

    // 32 . Индикатор превышения уровня шума в помещениях (превышен или не превышен в данный момент)
    var noiseIndicator: Boolean = true

    // 33 . План взаимодействия с прессой
    val pressPlan: String = "plan"

    // 34 . Детальная публичная информация о проектах каждой команды, сбор данных включает в себя компиляцию кода и сбор статистики прогона автоматизированных проверок.
    lateinit var comandPublicInfo: String

    // 35 . Статус получения всех необходимых разрешений для проведения мероприятия
    var permissionStatusInfo: String = "permission"

    // 36 . Индикатор доступности специализированного оборудования в данный момент (например, специальному оборудованию)
    var indicatorAcessEquipment: Boolean = true

    // 37 . Список партнеров мероприятия
    var partnersList: String = "list of partners"

    // 38 . Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.
    val reportAfterEvent by lazy {
        "report"
    }

    // 39 . Внутренние правила распределения призов
    private val internalRulePrizes: String = ""

    // 40 . Список разыгрываемых призов
    val prizesList: String = ""

    // 41 . Контактная информация экстренных служб, медицинского персонала и других важных служб, для внутреннего пользования.
    val emergencyInfo: String = ""

    // 42 . Особые условия для участников с ограниченными возможностями
    val accessabilitySpecialAction: String = ""

    // 43 . Общее настроение участников (определяется опросами)
    var moodOfParticipants: String = ""

    // 44 . Подробный план хакатона, включающий время и содержание каждого сегмента, инициализируется непосредственно перед началом мероприятия, так как зависит от фактического состава команд и взятых в работу задач.
    lateinit var hakatonPlan: String

    // 45 . Имя знаменитого специального гостя, которое будет объявлено за день до мероприятия, но в момент инициализации неизвестно.
    lateinit var nameFamousGuest: String

    // 46 . Максимальное количество людей, которое может вместить место проведения.
    val maxCountOfPeople: Int = 100

    // 47 . Количество часов, отведенное каждой команде для работы над проектом.
    val timeCountToTeam: Int = 5
}