package kr.hs.emirim.shookhee.quizlocker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import kr.hs.emirim.shookhee.quizlocker.adapter.CollectionAdapter;
import kr.hs.emirim.shookhee.quizlocker.model.Carrot;


public class CollectionActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    GridLayoutManager mLayoutManager;
    CollectionAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collection);
        recyclerView = (RecyclerView)findViewById(R.id.collection_recycler);
        adapter = new CollectionAdapter();
        mLayoutManager = new GridLayoutManager(this, 3);
//        mLayoutManager.setReverseLayout(true);
//        mLayoutManager.setStackFromEnd(true);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setAdapter(adapter);

        adapter.addItem(new Carrot(
                "기본당근",
                "라이브러리 vs 프레임워크\n\n" +
                        "프레임워크란?\n" +
                        " 프레임워크는 큰 틀을 제공하고 내 코드는 프레임워크의 틀 안에 맞춰서 작성해야 합니다. " +
                        "큰 뼈대는 이미 잡혀있고 그 안의 내용물을 채우는 느낌 입니다. 작동할 때 코드 실행 흐름을 보면 프레임워크가 내 코드를 호출합니다.\n\n" +
                        "라이브러리란?\n" +
                        " 라이브러리는 사용할 수 있는 함수들의 모음으로, 내가 라이브러리를 호출해서 능동적으로 사용합니다.",
                R.drawable.carrot_character01,
                0));
        adapter.addItem(new Carrot("락앤롤 당근",
                "즐거울 락 樂\n\n" +
                        "SDK란?\n" +
                        " Software Development Kit의 약자로, 개발을 위한 클래스, 컴파일러, 실행도구, 디버깅 툴, 예제 코드, 튜토리얼 등을 모아놓은 환경을 제공하는 것입니다.\n\n" +
                        " 모형배 만들기 키트를 예로들면, 재료 뿐만 아니라 자, 목공용 풀, 돋보기가 포함된 것 처럼, 개발을 위한 도구 세트입니다.",
                R.drawable.carrot_character02,
                10));
        adapter.addItem(new Carrot("소민지",
                "당근이 되어버린 3107 소민지쿤;;\n\n" +
                        "MVP 패턴이란?\n" +
                        " 애플리케이션을 Model, View, Controller 영역으로 구분하여 개발합니다. 영역간의 결합도를 최소화한 디자인 패턴입니다.\n\n장점은\n" +
                        "1. 디자이너, 개발자 영역이 분리됨으로써 분업화가 쉬워지며,\n" +
                        "2. 유지보수가 용이합니다.",
                R.drawable.carrot_character03,
                20));
        adapter.addItem(new Carrot("꽐라 당근",
                "6개월 뒤 우리의 모습.\n\n" +
                        "오버라이딩이란?\n" +
                        " 부모 클래스에게 상속받은 메소드를 자식 클래스에서 재정의 하는 것입니다.\n\n" +
                        "오버로딩이란?\n" +
                        " 하나의 클래스 내에서 이름이 같은 여러개의 메서드를 정의하는 것입니다. parameter, 리턴 타입 등이 다른데 수행 내용이 본질적으로 동일할 때 사용합니다.",
                R.drawable.carrot_character04,
                30));
        adapter.addItem(new Carrot("미림 당근",
                "밤새 과제하다 썩어버린 우리의 모습\n\n" +
                        "NodeJS란?\n" +
                        " 서버사이드 자바스크립트이며 구글의 자바스크립트 엔진인 V8을 기반으로 구성된 일종의 소프트웨어 시스템입니다.\n\n" +
                        " 이벤트 기반으로 개발이 가능하며 Non-Blocking I/O를 지원하기 때문에 비동기식 프로그래밍이 가능합니다." +
                        "이 때문에 I/O 부하가 심한 대규모 서비스를 개발하기 적합하다고 할 수 있습니다.",
                R.drawable.carrot_character05,
                40));
        adapter.addItem(new Carrot("이연우",
                "귀엽다..하ㅏㅇㄱ\n\n" +
                        "toString 메소드란?\n" +
                        " 인스턴스에 대한 정보를 문자열로 제공하기 위한 목적으로 정의한 메서드로, 인스턴스를 출력하게되면 toString이 콜됩니다.",
                R.drawable.carrot_character06,
                50));
        adapter.addItem(new Carrot("짜르 당근",
                "짜잔~ 최영진 선생님 안녕하세요, 깜짝 이벤트 입니다.\n\n" +
                        "비동기 처리란?\n" +
                        " 자바스크립트의 비동기 처리란 특정 코드의 연산이 끝날 때까지 코드의 실행을 멈추지 않고 다음 코드를 먼저 실행하는 자바스크립트의 특성을 의미합니다.\n\n" +
                        "콜백 지옥이란?\n" +
                        " 콜백 지옥은 비동기 처리 로직을 위해 콜백 함수를 연속해서 사용할 때 발생하는 문제이다.",
                R.drawable.carrot_character07,
                60));
        adapter.addItem(new Carrot("스프링 당근",
                "여러분.. 대답 좀 해주세요.. 복습 좀 하시구요\n\n" +
                        "HTTPS란?\n" +
                        " HTTPS는 데이터가 암호화 되지 않는 HTTP의 단점을 극복하고자 HTTP에 SSL이라는 기술을 더한 것 입니다.\n\n" +
                        "SSL, 인증서란?\n" +
                        " SSL(Secure Sockets Layer)은 HTTPS 암호화 통신과 그 암호화 통신에 사용되는 키를 공유할 수 있도록 하는 기술입니다.",
                R.drawable.carrot_character08,
                70));
        adapter.addItem(new Carrot("근당 당근",
                "다니합영환 을것 신오 에쇼티이아 ,요세하녕안\n\n" +
                        "REST란?\n" +
                        " 웹에 존재하는 모든 자원(이미지, 동영상, DB 자원)에 고유한 URI를 부여해 활용하는 것으로, 자원을 정의하고 자원에 대한 주소를 지정하는 방법론을 의미합니다.\n\n" +
                        "REST 구성:\n" +
                        "1. 자원(Resource) - URI\n" +
                        "2. 행위(Verb) - HTTP Method\n" +
                        "3. 표현(Representations)",
                R.drawable.carrot_character09,
                80));
        adapter.addItem(new Carrot("찵싹~",
                "챱챱챱챱챱챱챱챱츄릅츄릅챱챱챱",
                R.drawable.carrot_character10,
                90));
        adapter.addItem(new Carrot("당근 10",
                "설명 10", R.drawable.carrot_character10,
                200));
        adapter.addItem(new Carrot("당근 10",
                "설명 10", R.drawable.carrot_character10,
                210));
        adapter.addItem(new Carrot("당근 10",
                "설명 10", R.drawable.carrot_character10,
                220));
        adapter.addItem(new Carrot("당근 10",
                "설명 10", R.drawable.carrot_character10,
                230));
        adapter.addItem(new Carrot("당근 10",
                "설명 10",
                R.drawable.carrot_character10,
                240));

        ImageView setting = (ImageView)findViewById(R.id.ivSetting);
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CollectionActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });
    }


    public void onClickBack(View v){
        super.onBackPressed();
    }
}