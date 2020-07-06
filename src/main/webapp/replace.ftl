<script type="text/javascript">
    'use strict';

    var _class, _temp, _class2, _temp2;

    var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

    function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

    function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

    function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

    var Legend = function () {
        function Legend() {
            _classCallCheck(this, Legend);

            this.valueOne = document.getElementById('goal_1');
            this.valueTwo = document.getElementById('goal_2');
            this.valueThree = document.getElementById('goal_3');
            //this.totalValue = document.getElementById('total');
        }

        _createClass(Legend, [{
            key: 'setValueOne',
            value: function setValueOne(value) {
                this.valueOne.textContent = value;
            }
        }, {
            key: 'setValueTwo',
            value: function setValueTwo(value) {
                this.valueTwo.textContent = value;
            }
        }, {
            key: 'setValueThree',
            value: function setValueThree(value) {
                this.valueThree.textContent = value;
            }
        }, {
            key: 'setTotalValue',
            value: function setTotalValue(value) {
                this.totalValue.textContent = value;
            }
        }, {
            key: 'updateValues',
            value: function updateValues(val1, val2, val3) {
                this.setValueOne(val1);
                this.setValueTwo(val2);
                this.setValueThree(val3);
            }
        }]);

        return Legend;
    }();

    var SliderWidget = (_temp = _class = function () {
        function SliderWidget(elem, widgetType) {
            _classCallCheck(this, SliderWidget);

            this.elem = elem;
            this.widgetType = widgetType;
            this.totalWidth;
            this.elemWidth;
        }

        _createClass(SliderWidget, [{
            key: 'setElemWidth',
            value: function setElemWidth(width) {
                var elem = this.elem;

                this.elemWidth = width;
                elem.style.width = width + 'px';
            }
        }, {
            key: 'getElemWidth',
            value: function getElemWidth() {
                return this.elemWidth;
            }
        }, {
            key: 'getElemWidthFromCss',
            value: function getElemWidthFromCss() {
                return parseFloat(this.elem.offsetWidth);
            }
        }]);

        return SliderWidget;
    }(), _class.WIDGET_TYPE = {
        HANDLE: 1,
        BAR: 2
    }, _temp);

    var SliderHandle = (_temp2 = _class2 = function (_SliderWidget) {
        _inherits(SliderHandle, _SliderWidget);

        function SliderHandle(elem, handleType) {
            _classCallCheck(this, SliderHandle);

            var _this = _possibleConstructorReturn(this, (SliderHandle.__proto__ || Object.getPrototypeOf(SliderHandle)).call(this, elem, SliderWidget.WIDGET_TYPE.HANDLE));

            _this.elemWidth = _this.getElemWidthFromCss();
            _this.handleType = handleType;
            _this.curPos;

            _this.bindEvents();
            return _this;
        }

        _createClass(SliderHandle, [{
            key: 'setPosition',
            value: function setPosition(x) {
                var elem = this.elem,
                    handleType = this.handleType;


                this.curPos = x;
                if (handleType === SliderHandle.HANDLE_TYPE.RIGHT) {
                    elem.style.transform = 'translate3d(-' + x + 'px, 0, 0)';
                } else {
                    elem.style.transform = 'translate3d(' + x + 'px, 0, 0)';
                }
            }
        }, {
            key: 'getPosition',
            value: function getPosition() {
                return this.curPos;
            }
        }, {
            key: 'bindEvents',
            value: function bindEvents() {
                var _this2 = this;

                var elem = this.elem,
                    bindEventHelper = this.bindEventHelper;


                var eventHelper = function eventHelper(e) {
                    e.preventDefault();
                    // We want the object with screenX property
                    if (e.touches) {
                        // Handle touch events
                        return e.touches[e.touches.length - 1];
                    }
                    return e;
                };

                elem.addEventListener('touchstart', function (e) {
                    return _this2.onPointerDown(eventHelper(e));
                });
                elem.addEventListener('mousedown', function (e) {
                    return _this2.onPointerDown(eventHelper(e));
                });

                window.addEventListener('touchmove', function (e) {
                    return _this2.onPointerMove(eventHelper(e));
                });
                window.addEventListener('mousemove', function (e) {
                    return _this2.onPointerMove(eventHelper(e));
                });

                window.addEventListener('touchend', function (e) {
                    return _this2.onPointerUp(eventHelper(e));
                });
                window.addEventListener('mouseup', function (e) {
                    return _this2.onPointerUp(eventHelper(e));
                });
            }
        }, {
            key: 'onPointerDown',
            value: function onPointerDown(e) {
                console.log('wrong poitner down');
            }
        }, {
            key: 'onPointerMove',
            value: function onPointerMove(e) {
                console.log('wrong poitner move');
            }
        }, {
            key: 'onPointerUp',
            value: function onPointerUp(e) {
                console.log('wrong poitner up');
            }
        }]);

        return SliderHandle;
    }(SliderWidget), _class2.HANDLE_TYPE = {
        RIGHT: 1,
        LEFT: 2
    }, _temp2);

    var SliderBar = function (_SliderWidget2) {
        _inherits(SliderBar, _SliderWidget2);

        function SliderBar(elem) {
            _classCallCheck(this, SliderBar);

            return _possibleConstructorReturn(this, (SliderBar.__proto__ || Object.getPrototypeOf(SliderBar)).call(this, elem, SliderWidget.WIDGET_TYPE.BAR));
        }

        return SliderBar;
    }(SliderWidget);

    var ThreeValueSlider = function () {
        function ThreeValueSlider(val1, val2, val3, totalVal) {
            _classCallCheck(this, ThreeValueSlider);

            this.sliderElem = document.getElementById('three-value-slider');

            var leftHandleElem = this.sliderElem.getElementsByClassName('slider-handle left')[0];
            this.leftHandle = new SliderHandle(leftHandleElem, SliderHandle.HANDLE_TYPE.LEFT);
            var rightHandleElem = this.sliderElem.getElementsByClassName('slider-handle right')[0];
            this.rightHandle = new SliderHandle(rightHandleElem, SliderHandle.HANDLE_TYPE.RIGHT);

            var leftBarElem = this.sliderElem.getElementsByClassName('slider-bar left')[0];
            this.leftBar = new SliderBar(leftBarElem);
            var middleBarElem = this.sliderElem.getElementsByClassName('slider-bar middle')[0];
            this.middleBar = new SliderBar(middleBarElem);
            var rightBarElem = this.sliderElem.getElementsByClassName('slider-bar right')[0];
            this.rightBar = new SliderBar(rightBarElem);

            this.value1 = val1;
            this.value2 = val2;
            this.value3 = val3;
            this.totalValue = totalVal;
            this.totalWidth = this.getTotalWidth();

            this.leftBar.setElemWidth(this.getWidthByValue(this.value1));
            this.middleBar.setElemWidth(this.getWidthByValue(this.value2));
            this.rightBar.setElemWidth(this.getWidthByValue(this.value3));

            // Placing handles at the right position
            this.leftHandle.setPosition(this.leftBar.getElemWidth());
            this.rightHandle.setPosition(this.rightBar.getElemWidth());

            this.bindEvents();
            this.trackLeftHandle();
            this.trackRightHandle();

            this.legend = new Legend();
            this.legend.setTotalValue(totalVal);
            this.legend.updateValues(val1, val2, val3);
        }

        _createClass(ThreeValueSlider, [{
            key: 'trackRightHandle',
            value: function trackRightHandle() {
                var _this4 = this;

                var rightHandle = this.rightHandle,
                    leftBar = this.leftBar,
                    rightBar = this.rightBar,
                    middleBar = this.middleBar;


                var tracker = {
                    pointerDown: false,
                    startX: 0,
                    rightBarStartWidth: 0,
                    middleBarStartWidth: 0,
                    handleStartPos: 0
                };

                var updateValues = function updateValues() {
                    var totalValue = _this4.totalValue,
                        value1 = _this4.value1;
                    // Value calculated based on rightBar delta

                    var newValue3 = _this4.getValueByWidth(rightBar.getElemWidth());
                    var newValue2 = totalValue - newValue3 - value1;

                    _this4.value3 = newValue3;
                    _this4.value2 = newValue2;

                    _this4.legend.updateValues(_this4.value1, _this4.value2, _this4.value3);
                };

                rightHandle.onPointerDown = function (e) {
                    console.log('rightHanlde on pointer down', e);
                    tracker.startX = e.screenX;
                    tracker.rightBarStartWidth = rightBar.getElemWidth();
                    tracker.middleBarStartWidth = middleBar.getElemWidth();
                    tracker.handleStartPos = rightHandle.getPosition();
                    tracker.pointerDown = true;
                };

                rightHandle.onPointerMove = function (e) {
                    if (!tracker.pointerDown) return;

                    var currentX = e.screenX;
                    var delta = tracker.startX - currentX;

                    var middleBarWidth = tracker.middleBarStartWidth - delta;
                    var rightBarWidth = tracker.rightBarStartWidth + delta;
                    if (middleBarWidth < 0) {
                        // right handle is next to the left handle
                        if (middleBar.getElemWidth() > 0) {
                            rightHandle.setPosition(_this4.totalWidth - leftBar.getElemWidth());
                            middleBar.setElemWidth(0);
                            rightBar.setElemWidth(_this4.totalWidth - leftBar.getElemWidth());

                            updateValues();
                        }
                    } else if (rightBarWidth < 0) {
                        // Right handle is at the very right
                        if (rightHandle.getPosition() > 0) {
                            rightHandle.setPosition(0);
                            rightBar.setElemWidth(0);
                            middleBar.setElemWidth(_this4.totalWidth - leftBar.getElemWidth());

                            updateValues();
                        }
                    } else {
                        rightHandle.setPosition(tracker.handleStartPos + delta);
                        rightBar.setElemWidth(tracker.rightBarStartWidth + delta);
                        middleBar.setElemWidth(tracker.middleBarStartWidth - delta);

                        updateValues();
                    }
                    console.log('values: ', leftBar.value, middleBar.value, rightBar.value);
                };

                rightHandle.onPointerUp = function (e) {
                    console.log('rightHanlde on pointer up', e);
                    tracker.pointerDown = false;
                };
            }
        }, {
            key: 'trackLeftHandle',
            value: function trackLeftHandle() {
                var _this5 = this;

                var leftHandle = this.leftHandle,
                    leftBar = this.leftBar,
                    middleBar = this.middleBar,
                    rightBar = this.rightBar;


                var tracker = {
                    pointerDown: false,
                    startX: 0,
                    leftBarStartWidth: 0,
                    middleBarStartWidth: 0,
                    handleStartPos: 0
                };

                var updateValues = function updateValues() {
                    var totalValue = _this5.totalValue,
                        value3 = _this5.value3;
                    // Value calculated based on leftBar delta

                    var newValue1 = _this5.getValueByWidth(leftBar.getElemWidth());
                    var newValue2 = totalValue - newValue1 - value3;

                    _this5.value1 = newValue1;
                    _this5.value2 = newValue2;

                    _this5.legend.updateValues(_this5.value1, _this5.value2, _this5.value3);
                };

                leftHandle.onPointerDown = function (e) {
                    console.log('leftHandle on pointer down', e);
                    tracker.startX = e.screenX;
                    tracker.leftBarStartWidth = leftBar.getElemWidth();
                    tracker.middleBarStartWidth = middleBar.getElemWidth();
                    tracker.handleStartPos = leftHandle.getPosition();
                    tracker.pointerDown = true;
                    console.log('tracker ', tracker);
                };

                leftHandle.onPointerMove = function (e) {
                    if (!tracker.pointerDown) return;

                    var currentX = e.screenX;
                    var delta = currentX - tracker.startX;

                    var middleBarWidth = tracker.middleBarStartWidth - delta;
                    var leftBarWidth = tracker.leftBarStartWidth + delta;
                    if (middleBarWidth < 0) {
                        // Left handle is next to the right handle
                        if (middleBar.getElemWidth() > 0) {
                            leftHandle.setPosition(_this5.totalWidth - rightBar.getElemWidth());
                            middleBar.setElemWidth(0);
                            leftBar.setElemWidth(_this5.totalWidth - rightBar.getElemWidth());

                            updateValues();
                        }
                    } else if (leftBarWidth < 0) {
                        // Left handle is at the very left
                        if (leftHandle.getPosition() > 0) {
                            leftHandle.setPosition(0);
                            leftBar.setElemWidth(0);
                            middleBar.setElemWidth(_this5.totalWidth - rightBar.getElemWidth());

                            updateValues();
                        }
                    } else {
                        leftHandle.setPosition(tracker.handleStartPos + delta);
                        leftBar.setElemWidth(tracker.leftBarStartWidth + delta);
                        middleBar.setElemWidth(tracker.middleBarStartWidth - delta);

                        updateValues();
                    }

                    console.log('values: ', leftBar.value, middleBar.value, rightBar.value);
                };

                leftHandle.onPointerUp = function (e) {
                    console.log('leftHandle on pointer up', e);
                    tracker.pointerDown = false;
                };
            }
        }, {
            key: 'bindEvents',
            value: function bindEvents() {
                var _this6 = this;

                var leftHandle = this.leftHandle,
                    rightHandle = this.rightHandle,
                    leftBar = this.leftBar,
                    middleBar = this.middleBar,
                    rightBar = this.rightBar;


                var updateWidth = _.throttle(function () {
                    var value1 = _this6.value1,
                        value2 = _this6.value2,
                        value3 = _this6.value3;

                    _this6.totalWidth = _this6.getTotalWidth();
                    leftBar.setElemWidth(_this6.getWidthByValue(value1));
                    middleBar.setElemWidth(_this6.getWidthByValue(value2));
                    rightBar.setElemWidth(_this6.getWidthByValue(value3));

                    leftHandle.setPosition(leftBar.getElemWidth());
                    rightHandle.setPosition(rightBar.getElemWidth());
                    console.log('update width to: ', _this6.totalWidth);
                }, 100);
                window.addEventListener('resize', updateWidth);
            }
        }, {
            key: 'getWidthByValue',
            value: function getWidthByValue(value) {
                var totalValue = this.totalValue,
                    totalWidth = this.totalWidth;

                return value / totalValue * totalWidth;
            }
        }, {
            key: 'getValueByWidth',
            value: function getValueByWidth(width) {
                var totalValue = this.totalValue,
                    totalWidth = this.totalWidth;

                return Math.round(width / totalWidth * totalValue);
            }
        }, {
            key: 'getTotalWidth',
            value: function getTotalWidth() {
                var sliderElem = this.sliderElem,
                    leftHandle = this.leftHandle;

                var sliderWidth = parseFloat(sliderElem.offsetWidth);
                var handleWidth = leftHandle.getElemWidth();

                // Exclude padding widths
                var totalWidth = sliderWidth - 2 * handleWidth;
                if (totalWidth < 0) totalWidth = 2 * handleWidth;

                return totalWidth;
            }
        }]);

        return ThreeValueSlider;
    }();

    var slider = new ThreeValueSlider(25, 25, 50, 100);
</script>