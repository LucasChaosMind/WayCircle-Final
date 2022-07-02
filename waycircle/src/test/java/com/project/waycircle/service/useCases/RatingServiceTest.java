package com.project.waycircle.service.useCases;

import com.project.waycircle.model.Clothes;
import com.project.waycircle.model.Customer;
import com.project.waycircle.model.Rating;
import com.project.waycircle.model.Stock;
import com.project.waycircle.model.enums.Gender;
import com.project.waycircle.model.enums.Size;
import com.project.waycircle.service.CRUD.ClothesServiceCRUD;
import com.project.waycircle.service.CRUD.RatingServiceCRUD;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDateTime;
import java.util.ArrayList;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
public class RatingServiceTest {


    private RatingService undeTest;
    @Mock
    private ClothesServiceCRUD clothesServiceCRUD;
    @Mock
    private RatingServiceCRUD ratingServiceCRUD;

    private Clothes clothes;
    private Rating rating;

    @BeforeEach
    void setup(){
        undeTest = new RatingService(clothesServiceCRUD,ratingServiceCRUD);
        clothes = Clothes.builder()
                .name("UnderTest")
                .description("UnderTest")
                .size(Size.M)
                .value(10.50)
                .stock(Stock.builder().quantity(5).lastModified(LocalDateTime.now()).build())
                .ratings(new ArrayList<>())
                .build();
        rating = Rating.builder()
                .desc("UnderTest")
                .stars(5)
                .cliente(Customer.builder()
                        .name("Custumer Test")
                        .cpf("1234")
                        .gender(Gender.MALE)
                        .build())
                .build();

    }
    @Test
    void saveNewRatingTest(){
        BDDMockito.given(clothesServiceCRUD.update(Mockito.any())).willReturn(clothes);

        BDDMockito.given(ratingServiceCRUD.save(Mockito.any())).willReturn(rating);

        Rating result = undeTest.saveNewRating(clothes,rating);
        assertThat(rating).isEqualTo(result);
    }
}
