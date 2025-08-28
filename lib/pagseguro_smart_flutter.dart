import 'package:flutter/services.dart';
import 'package:pagseguro_smart_flutter/payments/handler/nfc_handler.dart';
import 'package:pagseguro_smart_flutter/payments/nfc.dart';

import 'payments/handler/payment_handler.dart';
import 'payments/payment.dart';

// ignore: constant_identifier_names
const CHANNEL_NAME = "pagseguro_smart_flutter";

class PagseguroSmart {
  final MethodChannel _channel;
  Payment? _payment;
  Nfc? _nfc;

  static PagseguroSmart? _instance;

  PagseguroSmart(this._channel);

  static PagseguroSmart instance() {
    _instance ??= PagseguroSmart(const MethodChannel(CHANNEL_NAME));
    return _instance!;
  }

  //Function to init payment and register handler from notify
  void initPayment(PaymentHandler handler) {
    _payment = Payment(channel: _channel, paymentHandler: handler);
  }

  //Function to init nfc and register handler from notify
  void initNfc(NfcHandler handler) {
    _nfc = Nfc(channel: _channel, nfcHandler: handler);
    //Register handler from notify
  }

  Payment get payment {
    if (_payment == null) {
      throw "To use the payment platform first you need to initialize it. \n TRY: PagseguroSmart.instance().initPayment(handler)";
    }
    return _payment!;
  }

  Nfc get nfc {
    if (_nfc == null) {
      throw "To use the NFC platform first you need to initialize it! \n TRY: PagseguroSmart.instance().initNfc(handler)";
    }
    return _nfc!;
  }
}
