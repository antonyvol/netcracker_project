package client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.*;

/**
 * Created by antonyvol on 07.04.16.
 */
public class Client implements EntryPoint {
    public void onModuleLoad() {
        final String TEXTBOX_LENGTH = "220";

        // --------------------------------------------------------------------
        // форма добавления автомобиля
        final FormPanel carAddForm = new FormPanel();

        // панель, содержащая поля формы добавления автомобилей
        final VerticalPanel carAddPanel = new VerticalPanel();
        carAddPanel.setSpacing(10);

        // добавление полей ввода для формы автомобилей
        final TextBox carModel = new TextBox();
        carModel.setWidth(TEXTBOX_LENGTH);
        carModel.setName("carModelTextBox");
        carModel.getElement().setPropertyString("placeholder", "Car model");
        carAddPanel.add(carModel);

        final TextBox carRegplate = new TextBox();
        carRegplate.setWidth(TEXTBOX_LENGTH);
        carRegplate.setName("carRegplateTextBox");
        carRegplate.getElement().setPropertyString("placeholder", "Car regpalte");
        carAddPanel.add(carRegplate);

        final TextBox carYear = new TextBox();
        carYear.setWidth(TEXTBOX_LENGTH);
        carYear.setName("carYearTextBox");
        carYear.getElement().setPropertyString("placeholder", "Car year");
        carAddPanel.add(carYear);

        final TextBox carPrice = new TextBox();
        carPrice.setWidth(TEXTBOX_LENGTH);
        carPrice.setName("carPriceTextBox");
        carPrice.getElement().setPropertyString("placeholder", "Car price");
        carAddPanel.add(carPrice);

        // добавление кнопки сабмита для формы автомобилей
        carAddPanel.add(new Button("Submit", new ClickHandler() {
            @Override
            public void onClick(ClickEvent event) {
                carAddForm.submit();
            }
        }));

        // добавление ивент-хэндлеров, кодировки и метода отправки запроса
        carAddForm.setEncoding(FormPanel.ENCODING_MULTIPART);
        carAddForm.setMethod(FormPanel.METHOD_POST);
        carAddForm.setWidget(carAddPanel);
        carAddForm.addSubmitHandler(new FormPanel.SubmitHandler() {
            @Override
            public void onSubmit(FormPanel.SubmitEvent event) {
                // code goes here
                // validation goes here
            }
        });
        carAddForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
            @Override
            public void onSubmitComplete(FormPanel.SubmitCompleteEvent event) {
                // code goes here
            }
        });

        // добавление формы автомобилей в рут-панель
        DecoratorPanel cardp = new DecoratorPanel();
        cardp.add(carAddForm);
        RootPanel.get("car-form").add(cardp);

        // -------------------------------------------------------------------
        // форма добавления владельцев
        final FormPanel ownerAddForm = new FormPanel();

        // панель, содержащая поля формы добавления владельцев
        final VerticalPanel ownerAddPanel = new VerticalPanel();
        ownerAddPanel.setSpacing(10);

        // добавление полей ввода формы владельцев

    }
}
