# 데드풀과 울버린 영화의 CGV 강남에서 7/27에 상영하는 상영시간표를 조회하는 쿼리
SELECT 
	MO_TITLE '영화제목', TH_NAME '영화관', SC_NAME '상영관' , SD_DATE '상영일',  SD_TIME '상영시간'
FROM 
	SCHEDULE
		JOIN
	SCREEN ON SC_NUM = SD_SC_NUM
		JOIN
	THEATER ON SC_TH_NUM = TH_NUM
		JOIN
	MOVIE ON SD_MO_NUM = MO_NUM
    WHERE
		SD_DATE = '2024-07-27' AND TH_NAME = 'CGV 강남'  AND MO_TITLE = '데드풀과 울버린';

# CGV 강남 1관에 등록된 좌석을 조회하는 쿼리
SELECT 
	SE_NAME 좌석
FROM 
	SEAT
		JOIN
	SCREEN ON SC_NUM = SE_SC_NUM
		JOIN
	THEATER ON TH_NUM = SC_TH_NUM
WHERE
	SC_NAME = '1관' AND TH_NAME = 'CGV 강남' ;

# abc123 회원이 예약한 예매 내역을 조회하는 쿼리 (영화 제목, 극장이름, 상영관 이름, 시간, 좌석번호)
SELECT
	MO_TITLE 영화, TH_NAME 극장, SC_NAME 상영관, SD_DATE 일시, SD_TIME 시간, SE_NAME 좌석
FROM
	TICKETING
	JOIN TICKETING_LIST ON TI_NUM = TL_TI_NUM
	JOIN SEAT ON SE_NUM = TL_SE_NUM	
	JOIN SCHEDULE ON SD_NUM = TI_SD_NUM	
	JOIN MOVIE ON MO_NUM = SD_MO_NUM	
	JOIN SCREEN ON SC_NUM = SD_SC_NUM
	JOIN THEATER ON TH_NUM = SC_TH_NUM
WHERE TI_ME_ID = 'abc123';

# 데드풀과 울버린 CGV 강남점 1관 7/27 10:00에 예약 가능한 좌석을 조회하는 쿼리